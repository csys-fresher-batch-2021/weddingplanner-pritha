package in.pritha.validator;

public class StringValidator {
	private StringValidator() {
		// to avoid object creation
	}

	/**
	 * This method checks the input string is valid or not
	 * 
	 * @param input is a string
	 * @return false if input is a null or special character contained string or
	 * length>30 or number contained string
	 */
	public static boolean isValidString(String input) {
		boolean isValid = true;
		input = input.trim();
		if (input == null || input.equals("") || input.length() > 30) {
			throw new NullPointerException("Invalid input");
		}
		
		String specialCharactersString = "!@#$%&*()'+,-./:;<=>?[]^_`{|}";
		String numbers = "0123456789";
		for (int i = 0; i < input.length(); i++) {
			char ch = input.charAt(i);
			if (specialCharactersString.contains(Character.toString(ch)) || numbers.contains(Character.toString(ch))) {
				isValid = false;
				break;
			}
		}
		return isValid;
	}
	

}