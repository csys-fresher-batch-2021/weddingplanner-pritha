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
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1-Get Form values
				String username = request.getParameter("Username");
				String password = request.getParameter("Password");
				Long mobileno = Long.parseLong(request.getParameter("phone_number"));
			//set values
				User user = new User(username,password,mobileno);
			//2-Call Service
				boolean isNewUser=true;
				try {
					//3-call service
					UserLoginService.register(user);
				} catch (ClassNotFoundException | SQLException e) {
	
					e.printStackTrace();
				}
				if(isNewUser){
					HttpSession session = request.getSession();
					session.setAttribute("RegisteredUser",username);
					session.setAttribute("Role","Customer");
					response.sendRedirect("LoginJSP.jsp");
				}
				else {
					response.sendRedirect("register.jsp?errorMessage=Invalid register Credentials");
				}
	}

}
