package in.pritha.validator;

public class NumberValidator {
	private NumberValidator() {
		//to avoid object creation
	}

	/**
	 * This method checks the input number is valid number should be greater than 0
	 * and not equal to null and length should not be greater than 10
	 * 
	 * @param input number
	 * @return true if its valid
	 */
	public static boolean isValidNumber(Integer input) {
		boolean isValid = true;
		if (input < 0 || input == 0 || String.valueOf(input).length() > 10) {
			isValid = false;
		}
		return isValid;
	}
}
