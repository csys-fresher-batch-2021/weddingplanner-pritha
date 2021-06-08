package in.pritha.controller;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.time.LocalDate;

import in.pritha.exception.ControllerException;
import in.pritha.exception.ServiceException;
import in.pritha.model.Discount;
import in.pritha.model.Payment;
import in.pritha.service.DiscountManager;
import in.pritha.service.PaymentManager;
import in.pritha.util.Logger;

public class PaymentController {
	public PaymentController() {
		
	}
	/**
	 * This method sets the input fields using model class 
	 * It calls the payment service to validate card details
	 * @param cardType
	 * @param cardUserName
	 * @param cardNumber
	 * @param cardExpiryDate
	 * @param cvv
	 * @param amount
	 * @param purpose
	 * @param discountCode
	 * @return otp
	 * @throws ControllerException
	 */
	public String validateCard(String cardType, String cardUserName, Long cardNumber, LocalDate cardExpiryDate, Integer cvv, Integer amount, String purpose,String discountCode        ) throws ControllerException {
		
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
			payment.setDiscountCode(discountCode);
			Logger.println("calling service");
			 otp = PaymentManager.generateOTP(payment);
			
		}catch(ServiceException e) {
			e.getMessage();
			// create a PrintWriter
			StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            e.printStackTrace(pw);
			throw new ControllerException(e,"Unable to call service to validate payment details");
			
		}
		return otp;
	}

	
/**
 * This method validates the entered otp with the generated otp
 * @param otpIndex1
 * @param otpIndex2
 * @param otpIndex3
 * @param otpIndex4
 * @param generatedOTP
 * @return true if both equals
 */
	public boolean validateOTP(String otpIndex1, String otpIndex2, String otpIndex3, String otpIndex4, String generatedOTP) {
		boolean enteredOtpValidated = false;
		if(generatedOTP.equals(otpIndex1+otpIndex2+otpIndex3+otpIndex4)) {
			enteredOtpValidated = true;
		}
		return enteredOtpValidated;
	}
	/**
	 * This method used to add transaction details to dao 
	 * It sets the input field and calls the service to do that
	 * @param cardUserName
	 * @param bookingId
	 * @param cardType
	 * @param amount
	 * @param status
	 * @param transactioncode
	 * @return true if payment details added
	 * @throws ControllerException
	 */
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
	/**
	 * This method used to update discount details for the logged in user name
	 * @param userName
	 * @return true if updated
	 * @throws ControllerException
	 */
	public boolean updateDiscountDetails(String userName)
			throws ControllerException {
		boolean isAdded = false;
	try {
		Discount discount = new Discount();
		discount.setUsername(userName);
		isAdded = DiscountManager.updateDiscountDetails(discount);
		
	}catch(Exception e) {
		e.getMessage();
		e.printStackTrace();
		throw new ControllerException(e,"Unable to call service to add discount details");
		
	}
	return isAdded;
	}

}
