package in.pritha.service;

import java.util.ArrayList;

import in.pritha.exception.ServiceException;
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
			otp = OTPUtil.generateOTP();		

		}
		return otp;
	}


}
