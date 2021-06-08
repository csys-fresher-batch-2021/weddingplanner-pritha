package in.pritha.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

import java.time.LocalTime;
import java.util.List;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import in.pritha.model.Booking;
import in.pritha.service.BookingManager;
import in.pritha.util.LocalDateAdapter;

import in.pritha.util.LocalTimeAdapter;
import in.pritha.util.Logger;
import in.pritha.util.ServletUtil;


/**
 * Servlet implementation class ListBookingServlet
 */
@WebServlet("/ListBookingServlet")
public class ListBookingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Logger.println("ListBookingServlet");
		try {
	
			HttpSession session = request.getSession();
			String userName = (String)session.getAttribute("VerfiedLoggedInUser");
			Logger.println(userName);
		
			List<Booking> bookingDetailsList = BookingManager.listBookingDetails(userName);
			Logger.println("Booking List"+ bookingDetailsList);
		
		Gson gson = new GsonBuilder().setPrettyPrinting()
		        .registerTypeAdapter(LocalTime.class, new LocalTimeAdapter())
		        .registerTypeAdapter(LocalDate.class, new LocalDateAdapter()).create();
		

		
	
		 
		  String json = gson.toJson(bookingDetailsList);
		 Logger.println("Approach #2: GSON JAR \n" + json); // Step 2: Write the
		 // json in response and flush it
		  PrintWriter out = response.getWriter();
		  out.print(json); 
		  out.flush();
		
	}catch(Exception e){
		ServletUtil.sendRedirect(response,"booking.jsp");
	}

	
	}
}
