package in.pritha.servlet;



import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import in.pritha.exception.ServiceException;
import in.pritha.model.User;
import in.pritha.service.UserService;
import in.pritha.util.ServletUtil;

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
			isMatchedPassword = UserService.createAndConfirmPassword(user);
			if(isMatchedPassword) {
				String infoMessage = "Password Changed Successfully";
				ServletUtil.sendRedirect(response,"LoginJSP.jsp?infoMessage=" + infoMessage);
			}
			else {
				String errorMessage = "Unable to change your password";
				ServletUtil.sendRedirect(response,"forgetpassword.jsp?errorMessage=" + errorMessage);
			}
		} catch ( ServiceException e) {
			String errorMessage = "Unable to change your password";
			ServletUtil.sendRedirect(response,"forgetpassword.jsp?errorMessage=" + errorMessage);
			
		} 
	}

	

}
