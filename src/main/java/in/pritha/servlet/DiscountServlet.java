package in.pritha.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.pritha.exception.ServiceException;
import in.pritha.service.DiscountManager;
import in.pritha.util.ServletUtil;

/**
 * Servlet implementation class DiscountServlet
 */
@WebServlet("/DiscountServlet")
public class DiscountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String loggedInUserName = (String)session.getAttribute("VerfiedLoggedInUser");
		try {
			
			Integer earnedCoins =DiscountManager.checkEligibilityForDiscount(loggedInUserName);
			System.out.println("SERvlet earned coins"+earnedCoins);
			if(earnedCoins !=null && earnedCoins>=100 ) {
			String infoMessage="Congrats!You are eligible for discount!";
			//passing multiple parameters
			ServletUtil.sendRedirect(response, "discount.jsp?infoMessage="+infoMessage+"&earnedCoins="+earnedCoins);
		
		}else if(earnedCoins==null){
			String errorMessage ="You are not eligible for discount!";
			ServletUtil.sendRedirect(response, "index.jsp?errorMessage="+errorMessage);
			
		}
			}
		catch (ServiceException e) {
			String errorMessage ="You are not eligible for discount!Check Your coins ";
			ServletUtil.sendRedirect(response, "index.jsp?errorMessage="+errorMessage);
			
		}
		
	}

	

}
