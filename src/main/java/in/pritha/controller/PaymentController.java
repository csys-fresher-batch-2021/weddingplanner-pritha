package in.pritha.controller;

import java.time.LocalDate;

import in.pritha.model.Payment;
import in.pritha.service.PaymentManager;

public class PaymentController {
	private PaymentController() {
		
	}
	public String validateCard(String cardType, String cardUserName, Long cardNumber, LocalDate cardExpiryDate, Integer cvv, Integer amount, String purpose        ) {
		
		String otp=null;
		try {
			Payment payment = new Payment();
			payment.setCardType(cardType);
			payment.setUserName(cardUserName);
			payment.setCardNo(cardNumber);
			payment.setExpiryDate(cardExpiryDate);
			payment.setCvv(cvv);
			payment.setAmount(amount);
			payment.setPurpose(purpose);
			 otp = PaymentManager.generateOTP(payment);
			
		}catch(Exception e) {
			e.getMessage();
			e.printStackTrace();
			
		}
		return otp;
	}

	public boolean validateOTP(String otpIndex1, String otpIndex2, String otpIndex3, String otpIndex4, String generatedOTP) {
		boolean enteredOtpValidated = false;
		if(generatedOTP.equals(otpIndex1+otpIndex2+otpIndex3+otpIndex4)) {
			enteredOtpValidated = true;
		}
		return enteredOtpValidated;
	}

}
