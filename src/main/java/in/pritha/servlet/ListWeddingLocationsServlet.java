package in.pritha.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.pritha.exception.ServiceException;
import in.pritha.service.WeddingStylesService;
import in.pritha.util.ServletUtil;

/**
 * Servlet implementation class ListWeddingLocationsServlet
 */
@WebServlet("/ListWeddingLocationsServlet")
public class ListWeddingLocationsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)  {
	
		
		try {
			Map<String, Integer> weddinglocations = WeddingStylesService.getWeddingLocations();
			request.setAttribute("WEDDING_LOCATIONS", weddinglocations);
			RequestDispatcher dispatcher = request.getRequestDispatcher("listweddinglocations.jsp");
			dispatcher.forward(request, response);
		} catch (ServiceException | ServletException | IOException e) {
			e.printStackTrace();
			ServletUtil.sendRedirect(response, "listweddinglocations.jsp");
			
		}
	}

	

}
