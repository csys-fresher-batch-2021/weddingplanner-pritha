package in.pritha.service;

import java.util.ArrayList;

import in.pritha.dao.PaymentDAO;
import in.pritha.exception.DBException;
import in.pritha.exception.ServiceException;

import in.pritha.model.Payment;
import in.pritha.util.Logger;
import in.pritha.validator.PaymentValidator;


public class PaymentManager {
	
	private PaymentManager() {
		
	}
	/**
	 * This method generates otp if all the validation is done
	 * It will return error list if there is any error
	 * @param user
	 * @return otp
	 * @throws ServiceException
	 */
	public static String generateOTP(Payment user) throws ServiceException {
		String otp = null;
		ArrayList<String> errorsLists = PaymentValidator.errorsList(user);
		
		if (!errorsLists.isEmpty()) {
			throw new ServiceException("Invalid card details");
		} else {
			Logger.println("calling to send otp to mobile");
			//real time otp is sended
			otp = SendOtp.sendOtpToMobile();		

		}
		return otp;
	}
	
	/**
	 * This method add payment detais after the validation
	 * @param payment
	 * @return true if added
	 * @throws ServiceException
	 */
	public static boolean addpaymentDetails(Payment payment) throws ServiceException {
		boolean isPaymentDetailsAdded = false;
		try {
			PaymentDAO.addPaymentDetails(payment.getCardUserName(),payment.getBookingId(),payment.getCardType(),payment.getAmount(),payment.getStatus(),payment.getTransactionCode());
			isPaymentDetailsAdded = true;
		} catch (DBException e) {
			e.printStackTrace();
			e.getMessage();
			throw new ServiceException(e,"Can't add payment details");
			
		}
		return isPaymentDetailsAdded;
		
	}
	
	
	


}
