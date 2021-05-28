package in.pritha.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.pritha.exception.ServiceException;
import in.pritha.model.Booking;
import in.pritha.service.BookingManager;



/**
 * Servlet implementation class ViewAllBookingDetailsServlet
 */
@WebServlet("/ViewAllBookingDetailsServlet")
public class ViewAllBookingDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    @Override   
    protected void doGet(HttpServletRequest request, HttpServletResponse response)  {
    	List<Booking> allBookingsList;
		try {
			allBookingsList = BookingManager.listAllBookingDetails();
			request.setAttribute("ALLBOOKINGLIST", allBookingsList);
			RequestDispatcher dispatcher = request.getRequestDispatcher("allbookingslist.jsp");
			dispatcher.forward(request, response);
		} catch (ServiceException | ServletException | IOException e) {
			e.printStackTrace();
		}
		
	}


}
