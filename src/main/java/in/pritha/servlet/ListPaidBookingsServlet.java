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

import in.pritha.model.Payment;
import in.pritha.service.BookingManager;

/**
 * Servlet implementation class ListPaidBookingsServlet
 */
@WebServlet("/ListPaidBookingsServlet")
public class ListPaidBookingsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			List<Payment> allPaidBookingsList = BookingManager.listAllPaidBookingDetails();
			request.setAttribute("ALLPAIDBOOKINGLIST", allPaidBookingsList);
			RequestDispatcher dispatcher = request.getRequestDispatcher("allpaidbookingslist.jsp");
			dispatcher.forward(request, response);
		} catch (ServiceException | ServletException | IOException e) {
			e.printStackTrace();
		}
		
	}
	}

	

