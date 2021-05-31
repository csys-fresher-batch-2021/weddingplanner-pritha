package in.pritha.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.pritha.exception.ServiceException;
import in.pritha.service.UserService;

/**
 * Servlet implementation class LogoutServlet
 */
@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String logoutUser = (String) session.getAttribute("VerfiedLoggedInUser");
		try {
		if(logoutUser!=null && session!=null) {
			boolean isUserInActivated = UserService.inActivateUser(logoutUser) ;
			if(isUserInActivated){
			request.getSession().setAttribute(logoutUser,"null");
			session.invalidate();
			String infoMessage = "Logged Out Succesfully!";
			RequestDispatcher dispatcher = request.getRequestDispatcher("logout.jsp?infoMessage="+infoMessage);
			dispatcher.forward(request, response);
		}}
		else {
			String errorMessage = "You must Login to Logout!";
			RequestDispatcher dispatcher = request.getRequestDispatcher("logout.jsp?errorMessage="+errorMessage);
			dispatcher.forward(request, response);
			
		}
	}catch(ServiceException e) {
		String errorMessage = "You must Login to Logout!";
		RequestDispatcher dispatcher = request.getRequestDispatcher("logout.jsp?errorMessage="+errorMessage);
		dispatcher.forward(request, response);
	}
		
	}


}
