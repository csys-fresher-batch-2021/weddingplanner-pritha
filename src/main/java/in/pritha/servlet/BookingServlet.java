package in.pritha.servlet;


import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.pritha.exception.ServiceException;
import in.pritha.model.Booking;
import in.pritha.model.WeddingStyle;
import in.pritha.service.BookingManager;
import in.pritha.service.BudgetEstimationService;
import in.pritha.util.Logger;




/**
 * Servlet implementation class BookingServlet
 */
@WebServlet("/BookingServlet")
public class BookingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	/**
	 * @throws IOException 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1-Get Form values
		Integer bookingId= BookingManager.generateBookingId(1000,8888);
		Logger.println("****"+bookingId);
		String status="BOOKED";
		String userName = request.getParameter("BookingUsername");
		LocalDate weddingDate = LocalDate.parse(request.getParameter("wdate"));
		LocalTime weddingTime =LocalTime.parse( request.getParameter("wtime"));
		String weddingLocation = request.getParameter("wloc");
		String weddingStyle = request.getParameter("weddingstyles");
		
		String weddingStyleLocation = request.getParameter("locations");
		
		String weddingFoodType = request.getParameter("food");
		
		String weddingGuestCount = request.getParameter("guest");
		
		String weddingDecorType = request.getParameter("decor");
		
	//set values
		
		Booking booking = new Booking(bookingId,status,userName,weddingDate,weddingTime,weddingLocation,weddingStyle,weddingStyleLocation,weddingFoodType,weddingGuestCount,weddingDecorType);
		WeddingStyle wed = new WeddingStyle(weddingStyle,weddingStyleLocation,weddingFoodType,weddingGuestCount,weddingDecorType);

	//2-Call Service
		try {
			if(BookingManager.validateBooking(booking) ) {
				
				//create and set values to session
				HttpSession session = request.getSession();
				session.setAttribute("BOOKING_DETAIL", booking);
				
				session.setAttribute("BookedUserName",userName);
				session.setAttribute("BOOKING_ID", bookingId);
				
				
				session.setAttribute("BOOKING_STATUS", status);
				//3-redirect to next page if details are correct
				
			
				Integer fare = BudgetEstimationService.fareEstimation(wed);
				request.setAttribute("FARE", fare);
				session.setAttribute("FARE", fare);
				ServletContext servletcontext = getServletContext();
				servletcontext.setAttribute("FARE", fare);
				servletcontext.setAttribute("BOOKING_ID", bookingId);
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("bookingsummary.jsp");
				dispatcher.forward(request, response);
				
			}
			
		} catch (ServiceException  | IOException e) {
			//4-redirect to same page if details are incorrect
			String errorMessage = "Booking failed";
			response.sendRedirect("booking.jsp?errorMessage="+errorMessage);
			e.printStackTrace();
		}
	}



}