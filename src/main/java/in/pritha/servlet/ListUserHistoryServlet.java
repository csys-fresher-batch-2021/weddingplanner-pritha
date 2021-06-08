package in.pritha.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.pritha.dto.UserHistoryDTO;
import in.pritha.exception.ServiceException;

import in.pritha.service.UserService;
import in.pritha.util.Logger;

/**
 * Servlet implementation class ListUserDetailsServlet
 */
@WebServlet("/ListUserHistoryServlet")
public class ListUserHistoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	 @Override   
	    protected void doGet(HttpServletRequest request, HttpServletResponse response)  {
	    	List<UserHistoryDTO> userDetailsList;
			try {
				HttpSession session = request.getSession();
				String userName =(String) session.getAttribute("VerfiedLoggedInUser");
				
				
				Logger.println(userName);
				
				userDetailsList = UserService.listUserDetailsByUsername(userName);
				request.setAttribute("USERHISTORY", userDetailsList);
				RequestDispatcher dispatcher = request.getRequestDispatcher("userhistorybyusername.jsp");
				dispatcher.forward(request, response);
			} catch (ServiceException | ServletException | IOException e) {
				e.printStackTrace();
			}
			
		}
	
}
