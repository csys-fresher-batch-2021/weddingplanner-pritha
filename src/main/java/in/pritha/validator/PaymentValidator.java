package in.pritha.validator;
import java.time.LocalDate;
import java.util.ArrayList;

import in.pritha.model.Payment;

public class PaymentValidator {
	private PaymentValidator() {
		
	}
		static ArrayList<String> paymentTypes = new ArrayList<String>();

		/**
		 * This method checks the input string is valid or not
		 * 
		 * @param input is a string
		 * @return false if input is a null or special character contained string
		 */
		public static boolean isValidString(String input) {
			boolean isValid = true;
			input = input.trim();
			String specialCharactersString = "!@#$%&*()'+,-./:;<=>?[]^_`{|}";
			String numbers = "0123456789";
			for (int i = 0; i < input.length(); i++) {
				char ch = input.charAt(i);
				if (input == null || input.equals("") || specialCharactersString.contains(Character.toString(ch))
						|| numbers.contains(Character.toString(ch))) {
					isValid = false;
					break;
				}
			}
			return isValid;
		}

		/**
		 * This method checks whether the expiry date of card is valid or not
		 * 
		 * @param localDate
		 * @return true if given date is after the current date
		 */
		public static boolean isExpired(LocalDate expiryDate) {
			LocalDate today = LocalDate.now();
			boolean isValid = today.isBefore(expiryDate);
			
			return isValid;
		}

		/**
		 * This method checks the online payment is in range min amount > 0 ; max amount
		 * <= 10,00000
		 * 
		 * @param amount
		 * @return true if it is in the given range
		 */
		public static boolean isInRangeAmount(Integer amount) {
			int min = 0;
			int max = 1000000;
			return amount > min && amount <= max;

		}

		/**
		 * This method checks whether the card number is valid The length of card must
		 * be >=13 and <=16 It must starts with 4 for visa cards It must starts with 5
		 * for master cards It must starts with 37 for american express cards It must
		 * starts with 6 for discover cards
		 * 
		 * @param cardNo
		 * @return true if the condition satisfies
		 */
		public static boolean isValidCardNumber(long cardNo) {
			boolean isvalidCard = false;
			String cardNoString = Long.toString(cardNo);
			int length = (Long.toString(cardNo)).length();
			if (length >= 13 && length <= 16) {
				if (cardNoString.startsWith("6", 0) || cardNoString.startsWith("4", 0) || cardNoString.startsWith("37", 0)
						|| cardNoString.startsWith("5", 0)) {
					isvalidCard = true;
				}
			}
			return isvalidCard;
		}

		/**
		 * This method checks whether the payment type is valid or not
		 * 
		 * @param paymentType
		 * @return true if it a valid payment type
		 */
		public static boolean isValidPaymentType(String paymentType) {
			// return paymentTypes.contains(paymentType);
			paymentTypes.add("Visa Card");
			paymentTypes.add("Rupay Card");
			paymentTypes.add("Master Card");
			paymentTypes.add("Discover Card");
			boolean isValidPayment = false;
			paymentType = paymentType.trim();
			if (isValidString(paymentType)) {
				for (String type : paymentTypes) {
					if (type.equalsIgnoreCase(paymentType)) {
						isValidPayment = true;
						break;

					}
				}
			}

			return isValidPayment;
		}

		/**
		 * This method display all the available payment type
		 */
		static {

			paymentTypes.add("Visa Card");
			paymentTypes.add("Rupay Card");
			paymentTypes.add("Master Card");
			paymentTypes.add("Discover Card");

		}

		/**
		 * This method checks whether the cvv number is valid cvv number should be
		 * between 3 to 4 digits It should not be in negative numbers
		 * 
		 * @param cvv
		 * @return
		 */
		public static boolean cvvNoValidation(Integer cvv) {
			boolean isValid = true;
			if (cvv > 0) {
				String cvvStr = Integer.toString(cvv);
				if (cvvStr.length() < 3 || cvvStr.length() > 4) {
					isValid = false;
				}
			} else {
				isValid = false;
			}

			return isValid;
		}

		/**
		 * This method checks whether the purpose of payment is valid
		 * 
		 * @param purpose
		 * @return true if its a valid string
		 */
		public static boolean purposeValidation(String purpose) {
			boolean isValid = false;
			if (isValidString(purpose)) {
				isValid = true;
			}
			return isValid;
		}

		/**
		 * This method used to generate otp for successful online payment with correct
		 * datas
		 * 
		 * @param expiryDate
		 * @param cardNo
		 * @param amount
		 * @param paymentType
		 * @param cvv
		 * @param purpose
		 * @return string of otp if all are valid datas
		 */

		

		// My proposed method after demo
		/**
		 * This method returns otp if the details are correct It will return error
		 * details if the deatils are incorrect
		 */
		public static ArrayList<String> errorsList(Payment payment) {
			
			ArrayList<String> errorsList = new ArrayList<String>();

			// In the first condition itself, It will return false if it is invalid
			// There is no need for multiple and condition here
			if (!isExpired(payment.getExpiryDate())) {
				errorsList.add("Your card is expired");
			}

			if (!isInRangeAmount(payment.getAmount())) {
				errorsList.add("Given amount is incorrect\n");
			}

			if (!isValidPaymentType(payment.getCardType())) {
				errorsList.add("Your card type is incorrect\n");
			}

			if (!cvvNoValidation(payment.getCvv())) {
				errorsList.add("Your cvv is invalid");
			}

			if (!isValidCardNumber(payment.getCardNo())) {
				errorsList.add("Your card is invalid");
			}

			
			return errorsList;
		}
		
	

}
