package in.pritha.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.pritha.controller.PaymentController;
import in.pritha.util.ServletUtil;

/**
 * Servlet implementation class CheckOtpServlet
 */
@WebServlet("/CheckOtpServlet")
public class CheckOtpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String otpIndex1=  request.getParameter("1");
		
		String otpIndex2=  request.getParameter("2");
		
		String otpIndex3= request.getParameter("3");
		String otpIndex4=  request.getParameter("4");
		HttpSession session = request.getSession();
		String generatedOTP = (String) session.getAttribute("OTP"); 
		System.out.println("ORGOTP "+generatedOTP);
		PaymentController payment = new PaymentController();
		
		boolean isOtpCorrect = payment.validateOTP(otpIndex1,otpIndex2,otpIndex3,otpIndex4,generatedOTP);
		if(isOtpCorrect) {
		RequestDispatcher dispatcher = request.getRequestDispatcher("final.jsp");
		dispatcher.forward(request, response);
		}else {
			String errorMessage="Entered OTP is incorrect";
			ServletUtil.sendRedirect(response, "otp.jsp?errorMessage="+errorMessage);
		}
		
		
	}

	
}
