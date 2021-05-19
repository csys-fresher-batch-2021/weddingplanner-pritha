package in.pritha.validator;

import in.pritha.service.WeddingStylesService;

public class WeddingStyleValidator {
	private WeddingStyleValidator() {
		// to avoid object creation
	}

	/**
	 * This method check whether the entered wedding style and package is valid to
	 * add If the wedding style exists already, it will throw exception If the
	 * stylename is a new wedding style, it will add that in the wedding style map
	 * Stylename and Packages gets validated before the logic starts
	 * 
	 * @param styleName
	 * @param packages
	 * @return true if the new wedding style and package is valid
	 */
	public static boolean isValidToAdd(String styleName, Integer packages) {
		boolean isValidToAdd = true;
		if (StringValidator.isValidString(styleName) && NumberValidator.isValidNumber(packages)) {
			if (WeddingStylesService.getWeddingStyles().containsKey(styleName.toUpperCase())) {
				isValidToAdd = false;
				throw new RuntimeException("This Wedding Style Name Already Exists!");
			}
		} else {
			throw new IllegalArgumentException("Entered StyleName or Package is invalid");
		}
		return isValidToAdd;
		
		
	}
}
