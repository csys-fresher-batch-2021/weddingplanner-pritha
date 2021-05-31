package in.pritha.servlet;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.pritha.exception.ServiceException;
import in.pritha.model.User;
import in.pritha.service.UserService;
import in.pritha.util.ServletUtil;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException  {
		//1-Get Form values
				String username = request.getParameter("Username");
				String password = request.getParameter("Password");
				//Long mobileno = Long.parseLong(request.getParameter("phone_number"));
			//set values
				User user = new User(username,password);
			//2-Call Service
				
				try {
					//3-call service
					boolean isNewUser=UserService.register(user);
					System.out.println("Hi"+isNewUser);
					if(isNewUser){
						HttpSession session = request.getSession();
						session.setAttribute("RegisteredUser",username);
						//session.setAttribute("Role","Customer");
						String infoMessage = "Successfully Registered";
						ServletUtil.sendRedirect(response, "LoginJSP.jsp?infoMessage="+infoMessage);
					}
					else {
						String errorMessage= "Invalid Details";
						ServletUtil.sendRedirect(response, "register.jsp?errorMessage="+errorMessage);
					}
				} catch (ServiceException e) {
					String errorMessage= "Invalid Details";
					ServletUtil.sendRedirect(response, "register.jsp?errorMessage="+errorMessage);
					
				}
				
				
	}

}
