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
       
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String value = request.getParameter("value");
		Logger.println(value);
		String redirectJsp = request.getParameter("jsp");
		Logger.println(redirectJsp);
		HttpSession session = request.getSession();
	if(redirectJsp.equals("decor.jsp")) {
		Logger.println("food choosed");
		session.setAttribute("FOODSTYLECHOOSEN",value);
		
	}
	else if(redirectJsp.equals("booking.jsp")) {
		Logger.println("decor choosed");
		session.setAttribute("DECORSTYLECHOOSEN",value);
	}
	else if(redirectJsp.equals("foodstyle.jsp")) {
		Logger.println("location choosed");
		session.setAttribute("LOCATIONSTYLECHOOSEN",value);
	}
	else if(redirectJsp.equals("cardweddingstyles.jsp")) {
		Logger.println("wedding style choosed");
		session.setAttribute("WEDDINGSTYLECHOOSEN",value);
	}
		request.setAttribute("infoMessage", "Item added to your Cart");
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(redirectJsp);
		dispatcher.forward(request, response);
	}

	

}
