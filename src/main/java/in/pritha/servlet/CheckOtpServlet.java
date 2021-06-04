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
import in.pritha.model.Payment;
import in.pritha.service.BookingManager;
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
		System.out.println("ORGOTP "+generatedOTP);
		PaymentController payment = new PaymentController();
		
		boolean isOtpCorrect = payment.validateOTP(otpIndex1,otpIndex2,otpIndex3,otpIndex4,generatedOTP);
		if(isOtpCorrect){
			ServletContext servletcontext = getServletContext();
		
			String cardUserName = (String)servletcontext.getAttribute("CARDUSERNAME");
		System.out.println("*"+cardUserName);
		
		Integer bookingId = (Integer)session.getAttribute("BOOKING_ID");
		System.out.println("*"+bookingId);
		
		
		String cardType = (String)servletcontext.getAttribute("CARDTYPE");
		System.out.println("*"+cardType);
		
		
		
		Integer amount = (Integer)servletcontext.getAttribute("AMOUNT");
		
		System.out.println("*"+amount);
		String status= "PAID";
		String transactioncode = (String) session.getAttribute("OTP");
		System.out.println("*"+transactioncode);
		boolean isAddPaymentDetails =payment.addPaymentDetails(cardUserName,bookingId,cardType,amount,status,transactioncode);
		String userName = (String) session.getAttribute("VerfiedLoggedInUser");
		System.out.println(userName);
	
		Integer numberOfBookings = BookingManager.calculateNumberOfBookingsForUser(userName);
		System.out.println("Number of Bookings" +numberOfBookings);
		Integer originalFare = (Integer) session.getAttribute("FARE");
		System.out.println(originalFare);
		//that means they used their discount- we have to update it in db
		if(originalFare > amount && isAddPaymentDetails) {
		boolean isAddDiscountDetails = payment.updateDiscountDetails(userName);
		System.out.println("DiscountUpdated"+isAddDiscountDetails);
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

    	
		
		
	
