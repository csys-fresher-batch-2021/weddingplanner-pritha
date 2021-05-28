package in.pritha.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import in.pritha.dao.WeddingAppDAO;
import in.pritha.exception.DBException;
import in.pritha.exception.ServiceException;
import in.pritha.model.WeddingStyle;

import in.pritha.validator.WeddingStyleValidator;

public class WeddingStylesService {
	private static final Map<String, Integer> weddingStylesMap = new HashMap<>();

	private WeddingStylesService() {
		// to avoid object creation
	}
	private static final List<WeddingStyle> imagesList= new ArrayList<>();
	// Static block gets executed when class is first loaded
	static {
		WeddingStyle wed1 = new WeddingStyle("traditional.jfif");
		imagesList.add(wed1);
		WeddingStyle wed2 = new WeddingStyle("formal.jpg");
		imagesList.add(wed2);
		WeddingStyle wed3 = new WeddingStyle("informal.jfif");
		imagesList.add(wed3);
		WeddingStyle wed4 = new WeddingStyle("vintage.jpg");
		imagesList.add(wed4);
		WeddingStyle wed5 = new WeddingStyle("festival.webp");
		imagesList.add(wed5);
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
	 * @throws ServiceException 
	 */
	public static Map<String, Integer> getWeddingStyles() throws ServiceException {
		Map<String, Integer> allWeddingStyles = null;
		try {
			allWeddingStyles= WeddingAppDAO.getAllWeddingStyles();
		} catch (DBException e) {
			e.printStackTrace();
			throw new ServiceException("Wedding styles cant be displayed");
		}
		return allWeddingStyles;
	}

	public static Map<String, Integer> getWeddingLocations() throws ServiceException {
		Map<String, Integer> allWeddingLocations = null;
		try {
			allWeddingLocations= WeddingAppDAO.getAllWeddingLocations();
		} catch (DBException e) {
			e.printStackTrace();
			throw new ServiceException("Wedding locations cant be displayed");
		}
		return allWeddingLocations;
	}

	

}
