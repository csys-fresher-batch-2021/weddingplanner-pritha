package in.pritha.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.pritha.exception.ServiceException;
import in.pritha.model.WeddingStyle;
import in.pritha.service.WeddingStylesService;
import in.pritha.util.ServletUtil;

/**
 * Servlet implementation class AddWeddingStylesServlet
 */
@WebServlet("/AddWeddingStylesServlet")
public class AddWeddingStylesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException{
		String styleName = request.getParameter("styleName");
		Integer packages = Integer.parseInt(request.getParameter("package"));
		WeddingStyle style = new WeddingStyle(styleName, packages);
		try {
			boolean sucessfullyAdded = WeddingStylesService.addWeddingStyles(style);
			if (sucessfullyAdded) {
				String infoMessage = "Wedding Style Added successfully";
				response.sendRedirect("listweddingstyles.jsp?infoMessage=" + infoMessage);
			} else {
				String errorMessage = "Unable to add product name";
				response.sendRedirect("addweddingstyles.jsp?errorMessage=" + errorMessage);
			}

		} catch (RuntimeException | IOException | ServiceException e) {
			ServletUtil.sendRedirect(response, "addweddingstyles.jsp");
			
			e.printStackTrace();
		} 
	}

}
