package in.pritha.servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.pritha.exception.DBException;
import in.pritha.exception.ServiceException;
import in.pritha.model.User;
import in.pritha.service.BookingService;

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
		String username = request.getParameter("Username");
		LocalDate weddingdate = LocalDate.parse(request.getParameter("wdate"));
		LocalTime weddingtime =LocalTime.parse( request.getParameter("wtime"));
		String weddinglocation = request.getParameter("wloc");
	//set values
		User user = new User(username,weddingdate,weddingtime,weddinglocation);
	//2-Call Service
		try {
			if(BookingService.booking(user)) {
				//3-redirect to next page if details are correct
				String infoMessage = "You are eligible for Booking.Go ahead!";
				response.sendRedirect("budgetestimation.jsp?infoMessage="+infoMessage);
			}
			else {
				String errorMessage = "Booking failed";
				response.sendRedirect("booking.jsp?errorMessage="+errorMessage);
			}
		} catch (ServiceException | DBException | IOException e) {
			//4-redirect to same page if details are incorrect
			String errorMessage = "Booking failed";
			response.sendRedirect("booking.jsp?errorMessage="+errorMessage);
			e.printStackTrace();
		}
	}

	

}
