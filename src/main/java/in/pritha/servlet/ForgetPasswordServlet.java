package in.pritha.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.pritha.exception.MyException;
import in.pritha.model.User;
import in.pritha.service.UserLoginService;

/**
 * Servlet implementation class ForgetPasswordServlet
 */
@WebServlet("/ForgetPasswordServlet")
public class ForgetPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		
		String createpassword = request.getParameter("CreatePassword");
		String confirmpassword = request.getParameter("ConfirmPassword");
		String username = request.getParameter("Username");
		User user = new User(createpassword,confirmpassword,username);
		try {
			boolean isMatchedPassword=true;
			try {
				isMatchedPassword = UserLoginService.createAndConfirmPassword(user);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			if(isMatchedPassword) {
				String infoMessage = "Password Changed Successfully";
				response.sendRedirect("LoginJSP.jsp?infoMessage=" + infoMessage);
			}
			else {
				String errorMessage = "Unable to change your password";
				response.sendRedirect("forgetpassword.jsp?infoMessage=" + errorMessage);
			}
		} catch (MyException | IOException e) {
			String errorMessage = e.getMessage();
			try {
				response.sendRedirect("forgetpassword.jsp?errorMessage=" + errorMessage);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} 
	}

	

}
