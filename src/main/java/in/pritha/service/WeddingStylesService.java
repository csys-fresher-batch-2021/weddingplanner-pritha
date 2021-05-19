package in.pritha.service;

import java.util.HashMap;
import java.util.Map;


import in.pritha.model.WeddingStyle;

import in.pritha.validator.WeddingStyleValidator;

public class WeddingStylesService {
	private static final Map<String, Integer> weddingStylesMap = new HashMap<>();

	private WeddingStylesService() {
		// to avoid object creation
	}

	// Static block gets executed when class is first loaded
	static {
		weddingStylesMap.put("TRADITIONAL WEDDING", 100000);
		weddingStylesMap.put("FORMAL WEDDING", 80000);
		weddingStylesMap.put("INFORMAL WEDDING", 90000);
		weddingStylesMap.put("FESTIVAL WEDDING", 300000);
		weddingStylesMap.put("VINTAGE STYLE WEDDING", 500000);
	}

	/**
	 * This method add the wedding styles with their packages entered by the admin
	 * If the wedding style exists already, it will throw exception If the stylename
	 * is a new wedding style, it will add that in the wedding style map
	 * Stylename and Packages gets validated before the logic starts
	 * @param styleName
	 * @param packages
	 * @return true if the new wedding style gets added
	 */
	public static boolean addWeddingStyles(WeddingStyle obj) {
		boolean isAdded = false;
		if(WeddingStyleValidator.isValidToAdd(obj.getWeddingStyles(), obj.getPackages())) {
			weddingStylesMap.put(obj.getWeddingStyles().toUpperCase(), obj.getPackages());
			isAdded = true;
		}
		return isAdded;	
	}

	/**
	 * This method gets all the available wedding styles with their package
	 * 
	 * @return weddingStylesMap
	 */
	public static Map<String, Integer> getWeddingStyles() {
		return weddingStylesMap;
	}

	

}
