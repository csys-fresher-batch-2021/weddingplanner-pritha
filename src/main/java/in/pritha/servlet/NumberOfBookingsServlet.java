package in.pritha.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import in.pritha.service.BookingManager;
import in.pritha.util.LocalDateAdapter;
import in.pritha.util.LocalTimeAdapter;
import in.pritha.util.ServletUtil;

/**
 * Servlet implementation class NumberOfBookingsServlet
 */
@WebServlet("/NumberOfBookingsServlet")
public class NumberOfBookingsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("NumberOfBookingsServlet");
		PrintWriter out = response.getWriter();
		try {
	
			
			String userName = request.getParameter("VerfiedLoggedInUser");
			System.out.println(userName);
		
			Integer numberOfBookings = BookingManager.calculateNumberOfBookingsForUser(userName);
			ServletContext servletcontext = getServletContext();
			servletcontext.setAttribute("NUMBEROFBOOKINGS", numberOfBookings);
			
			Gson gson = new Gson();
		

		
	
		 
		  String json = gson.toJson(numberOfBookings);
		 System.out.println("Approach #2: GSON JAR \n" + json); // Step 2: Write the
		 // json in response and flush it
		  
		  out.print(json); 
		  out.flush();
		
	}catch(Exception e){
		e.printStackTrace();
		String errorMessage ="Number of bookings can't be displayed";
		JsonObject object = new JsonObject();
		object.addProperty("errorMessage", errorMessage);
		out.print(object.toString());
		out.flush();
	}
	}

	
}
