package in.pritha.service;

import java.util.ArrayList;

import in.pritha.dao.PaymentDAO;
import in.pritha.exception.DBException;
import in.pritha.exception.ServiceException;
import in.pritha.model.Discount;
import in.pritha.model.Payment;
import in.pritha.util.OTPUtil;
import in.pritha.validator.PaymentValidator;


public class PaymentManager {
	
	private PaymentManager() {
		
	}
	public static String generateOTP(Payment user) throws ServiceException {
		String otp = null;
		ArrayList<String> errorsLists = PaymentValidator.errorsList(user);
		
		if (!errorsLists.isEmpty()) {
			throw new ServiceException("Invalid card details");
		} else {
			System.out.println("calling to send otp to mobile");
			otp = OTPUtil.generateOTP();		

		}
		return otp;
	}
	public static boolean addpaymentDetails(Payment payment) throws ServiceException {
		boolean isPaymentDetailsAdded = false;
		try {
			PaymentDAO.addPaymentDetails(payment.getUserName(),payment.getBookingId(),payment.getCardType(),payment.getAmount(),payment.getStatus(),payment.getTransactionCode());
			isPaymentDetailsAdded = true;
		} catch (DBException e) {
			e.printStackTrace();
			e.getMessage();
			throw new ServiceException(e,"Can't add payment details");
			
		}
		return isPaymentDetailsAdded;
		
	}
	
	
	


}
