package in.pritha.servlet;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.pritha.controller.PaymentController;
import in.pritha.util.ServletUtil;

/**
 * Servlet implementation class OnlinePaymentServlet
 */
@WebServlet("/OnlinePaymentServlet")
public class OnlinePaymentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1-get form values
			try {
				String cardType = request.getParameter("cardtypes");
			
				ServletContext servletcontext = getServletContext();
				servletcontext.setAttribute("CARDTYPE", cardType);
				
				
				
				String cardUserName= request.getParameter("cardusername");
				
				servletcontext.setAttribute("CARDUSERNAME", cardUserName);
				Long cardNumber= Long.parseLong(request.getParameter("ccn"));
				LocalDate cardExpiryDate= LocalDate.parse(request.getParameter("expirydate"));
				Integer cvv= Integer.parseInt(request.getParameter("cvv"));
				Integer amount= Integer.parseInt(request.getParameter("amount"));
				
				servletcontext.setAttribute("AMOUNT", amount);
				String purpose= request.getParameter("purpose");
				
				//2-call controller
				PaymentController payment = new PaymentController();
				String otp = payment.validateCard(cardType,cardUserName,cardNumber,cardExpiryDate,cvv,amount,purpose);
				HttpSession session = request.getSession();
				session.setAttribute("OTP", otp);
				RequestDispatcher dispatcher = request.getRequestDispatcher("otp.jsp");
				dispatcher.forward(request, response);
				
				
	}catch(Exception e) {
		String errorMessage = "Card validation Failed! Try Again";
		ServletUtil.sendRedirect(response,"onlinepayment.jsp="+errorMessage);
	}
	}
	

}
