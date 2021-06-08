package in.pritha.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.pritha.controller.PaymentController;
import in.pritha.exception.ControllerException;
import in.pritha.exception.ServiceException;

import in.pritha.service.BookingManager;
import in.pritha.util.Logger;
import in.pritha.util.ServletUtil;

/**
 * Servlet implementation class CheckOtpServlet
 */
@WebServlet("/CheckOtpServlet")
public class CheckOtpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    	try {
    	String otpIndex1=  request.getParameter("1");
		
		String otpIndex2=  request.getParameter("2");
		
		String otpIndex3= request.getParameter("3");
		String otpIndex4=  request.getParameter("4");
		HttpSession session = request.getSession();
		String generatedOTP = (String) session.getAttribute("OTP"); 
		Logger.println("ORGOTP "+generatedOTP);
		PaymentController payment = new PaymentController();
		
		boolean isOtpCorrect = payment.validateOTP(otpIndex1,otpIndex2,otpIndex3,otpIndex4,generatedOTP);
		if(isOtpCorrect){
			ServletContext servletcontext = getServletContext();
		
			String cardUserName = (String)servletcontext.getAttribute("CARDUSERNAME");
		Logger.println("*"+cardUserName);
		
		Integer bookingId = (Integer)session.getAttribute("BOOKING_ID");
		Logger.println("*"+bookingId);
		
		
		String cardType = (String)servletcontext.getAttribute("CARDTYPE");
		Logger.println("*"+cardType);
		
		
		
		Integer amount = (Integer)servletcontext.getAttribute("AMOUNT");
		
		Logger.println("*"+amount);
		String status= "PAID";
		String transactioncode = (String) session.getAttribute("OTP");
		Logger.println("*"+transactioncode);
		boolean isAddPaymentDetails =payment.addPaymentDetails(cardUserName,bookingId,cardType,amount,status,transactioncode);
		String userName = (String) session.getAttribute("VerfiedLoggedInUser");
		Logger.println(userName);
	
		Integer numberOfBookings = BookingManager.calculateNumberOfBookingsForUser(userName);
		Logger.println("Number of Bookings" +numberOfBookings);
		Integer originalFare = (Integer) session.getAttribute("FARE");
		Logger.println(originalFare);
		//that means they used their discount- we have to update it in db
		if(originalFare > amount && isAddPaymentDetails) {
		boolean isAddDiscountDetails = payment.updateDiscountDetails(userName);
		Logger.println("DiscountUpdated"+isAddDiscountDetails);
		String infoMessage ="Booking Successful With Applied Discount";
		RequestDispatcher dispatcher = request.getRequestDispatcher("final.jsp?infoMessage="+infoMessage);
		dispatcher.forward(request, response);
		}
		else if(isAddPaymentDetails) {
		String infoMessage ="Booking Successful With Payment";
		RequestDispatcher dispatcher = request.getRequestDispatcher("final.jsp?infoMessage="+infoMessage);
		dispatcher.forward(request, response);
		}}
		else {
			String errorMessage="Entered OTP is incorrect";
			ServletUtil.sendRedirect(response, "otp.jsp?errorMessage="+errorMessage);
		}
    }
		catch(ControllerException | ServiceException e) {
			String errorMessage="Entered OTP is incorrect";
			ServletUtil.sendRedirect(response, "otp.jsp?errorMessage="+errorMessage);
		}
    	
    }
}

    	
		
		
	
