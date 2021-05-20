package in.pritha.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.pritha.model.User;
import in.pritha.service.UserLoginService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException {
	//1-Get Form values
		String username = request.getParameter("Username");
		String password = request.getParameter("Password");
	//set values
		User user = new User(username,password);
	//2-Call Service
		boolean isLoggedInUser=true;
		try {
			isLoggedInUser = UserLoginService.login(user);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		if(isLoggedInUser) {
			//3-create and set values to session
			HttpSession session = request.getSession();
			session.setAttribute("VerfiedLoggedInUser",username);
			session.setAttribute("Role","Customer");
			String infoMessage = "Successfully logged In";
			try {
				response.sendRedirect("listweddingstyles.jsp?infoMessage="+infoMessage);
			} catch (IOException e) {
				e.printStackTrace();
			}
	
		}
		else {
			String errorMessage = "Login failed";
			try {
				response.sendRedirect("LoginJSP.jsp?errorMessage="+errorMessage);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
	}

	
}
