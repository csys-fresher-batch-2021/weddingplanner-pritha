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
			
			
			System.out.println("CANCEL SERVLET");
			HttpSession session = request.getSession();
			String bookedUserName = (String) session.getAttribute("BookedUserName");
			System.out.println(bookedUserName);
			Integer bookingId = (Integer) session.getAttribute("BOOKING_ID");
			System.out.println(bookingId);
			String bookingStatus = (String) session.getAttribute("BOOKING_STATUS");
			System.out.println(bookingStatus);
			String reason = request.getParameter("reason");
			System.out.println(reason);
			boolean iscancelled = BookingManager.cancelBooking(bookingId,bookedUserName,bookingStatus,reason) ;
			System.out.println(iscancelled);
			RequestDispatcher dispatcher = request.getRequestDispatcher("final.jsp");
			dispatcher.forward(request, response);
				
			}catch(Exception e){
				ServletUtil.sendRedirect(response,"bookingsummary.jsp");
			}

		
		

	}

	
}
