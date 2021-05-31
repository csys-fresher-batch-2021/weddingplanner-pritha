package in.pritha.controller;

import java.time.LocalDate;

import in.pritha.exception.ControllerException;
import in.pritha.model.Payment;
import in.pritha.service.PaymentManager;

public class PaymentController {
	public PaymentController() {
		
	}
	public String validateCard(String cardType, String cardUserName, Long cardNumber, LocalDate cardExpiryDate, Integer cvv, Integer amount, String purpose        ) throws ControllerException {
		
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
			throw new ControllerException(e,"Unable to call service to validate payment details");
			
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
	public boolean addPaymentDetails(String cardUserName, Integer bookingId, String cardType, Integer amount,
			String status, String transactioncode ) throws ControllerException {
		boolean isAdded = false;
	try {
		Payment payment = new Payment();
		payment.setUserName(cardUserName);
		payment.setBookingId(bookingId);
		payment.setCardType(cardType);
		payment.setAmount(amount);
		payment.setStatus(status);
		payment.setTransactionCode(transactioncode);
		isAdded = PaymentManager.addpaymentDetails(payment);
		
	}catch(Exception e) {
		e.getMessage();
		e.printStackTrace();
		throw new ControllerException(e,"Unable to call service to add payment details");
		
	}
	return isAdded;
	}

}
