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
 * Servlet implementation class ListWeddingStyleServlet
 */
@WebServlet("/ListWeddingStyleServlet")
public class ListWeddingStyleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   @Override    
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   try {
			Map<String, Integer> weddingstyles = WeddingStylesService.getWeddingStyles();
			request.setAttribute("WEDDING_STYLES", weddingstyles);
			RequestDispatcher dispatcher = request.getRequestDispatcher("listweddingstyles.jsp");
			dispatcher.forward(request, response);
		} catch (ServiceException | ServletException | IOException e) {
			e.printStackTrace();
			ServletUtil.sendRedirect(response, "listweddingstyles.jsp");
			
		}
	
	}

	

}
