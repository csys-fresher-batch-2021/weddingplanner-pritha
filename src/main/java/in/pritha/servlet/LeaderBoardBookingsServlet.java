package in.pritha.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import in.pritha.dto.BookingDTO;
import in.pritha.service.BookingManager;
import in.pritha.util.Logger;
import in.pritha.util.ServletUtil;

/**
 * Servlet implementation class LeaderBoardBookingsServlet
 */
@WebServlet("/LeaderBoardBookingsServlet")
public class LeaderBoardBookingsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
		List<BookingDTO> noOfBookings =BookingManager.calculateNumberOfBookings();
		Gson gson = new Gson();
		
		String json = gson.toJson(noOfBookings);
		 Logger.println("Approach #2: GSON JAR \n" + json); // Step 2: Write the
		 // json in response and flush it
		  PrintWriter out = response.getWriter();
		  out.print(json); 
		  out.flush();
		
	}catch(Exception e){
		ServletUtil.sendRedirect(response,"home.jsp");
	}

	
	}

	

}
