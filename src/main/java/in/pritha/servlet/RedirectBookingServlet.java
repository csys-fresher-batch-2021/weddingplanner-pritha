package in.pritha.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.pritha.util.Logger;

/**
 * Servlet implementation class RedirectBookingServlet
 */
@WebServlet("/RedirectBookingServlet")
public class RedirectBookingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String value = request.getParameter("value");
		Logger.println(value);
		String redirect_jsp = request.getParameter("jsp");
		Logger.println(redirect_jsp);
		HttpSession session = request.getSession();
	if(redirect_jsp.equals("decor.jsp")) {
		Logger.println("food choosed");
		session.setAttribute("FOODSTYLECHOOSEN",value);
		
	}
	else if(redirect_jsp.equals("booking.jsp")) {
		Logger.println("decor choosed");
		session.setAttribute("DECORSTYLECHOOSEN",value);
	}
	else if(redirect_jsp.equals("foodstyle.jsp")) {
		Logger.println("location choosed");
		session.setAttribute("LOCATIONSTYLECHOOSEN",value);
	}
	else if(redirect_jsp.equals("cardweddingstyles.jsp")) {
		Logger.println("wedding style choosed");
		session.setAttribute("WEDDINGSTYLECHOOSEN",value);
	}
		request.setAttribute("infoMessage", "Item added to your Cart");
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(redirect_jsp);
		dispatcher.forward(request, response);
	}

	

}
