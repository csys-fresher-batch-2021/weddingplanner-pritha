package in.pritha.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.pritha.service.BookingManager;
import in.pritha.util.Logger;
import in.pritha.util.ServletUtil;

/**
 * Servlet implementation class CancelBookingServlet
 */
@WebServlet("/CancelBookingServlet")
public class CancelBookingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			// Step 1: called service and Convert to Json string
			
			
			Logger.println("CANCEL SERVLET");
			HttpSession session = request.getSession();
			String bookedUserName = (String) session.getAttribute("BookedUserName");
			Logger.println(bookedUserName);
			Integer bookingId = (Integer) session.getAttribute("BOOKING_ID");
			Logger.println(bookingId);
			String bookingStatus = (String) session.getAttribute("BOOKING_STATUS");
			Logger.println(bookingStatus);
			String reason = request.getParameter("reason");
			Logger.println(reason);
			BookingManager.cancelBooking(bookingId,bookedUserName,bookingStatus,reason) ;
			//we should remove the session values as the booking is cancelled
			session.removeAttribute("BookedUserName");
			session.removeAttribute("BOOKING_ID");
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
				
			}catch(Exception e){
				String errorMessage = "Not able to cancel the booking";
				ServletUtil.sendRedirect(response,"bookingsummary.jsp?errorMessage="+errorMessage);
			}

		
		

	}

	
}
