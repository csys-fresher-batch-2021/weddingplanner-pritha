package in.pritha.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class WeddingStyleDisplay {
	private static Map<String, Integer> weddingStylesMap = new HashMap<String, Integer>();

	// Static block gets executed when class is first loaded
	static {
		weddingStylesMap.put("Traditional Wedding", 100000);
		weddingStylesMap.put("Formal Wedding", 80000);
		weddingStylesMap.put("Informal Wedding", 90000);
		weddingStylesMap.put("Festival Wedding", 300000);
		weddingStylesMap.put("Vintage style Wedding", 500000);
	}

	/**
	 * This method gets all the available wedding styles with their package
	 * 
	 * @return weddingStylesMap
	 */
	public static Map<String, Integer> getWeddingStyles() {
		return weddingStylesMap;
	}

	/**
	 * This method displays all the available wedding styles with thier package
	 */
	public static void displayWeddingStyles() {

		System.out.println("Wedding Types:");

		weddingStylesMap.put("Traditional Wedding", 100000);
		weddingStylesMap.put("Formal Wedding", 80000);
		weddingStylesMap.put("Informal Wedding", 90000);
		weddingStylesMap.put("Festival Wedding", 300000);
		weddingStylesMap.put("Vintage style Wedding", 500000);

		// to get key---> HashSet
		// to get value--->.get(key)
		Set<String> keySet = weddingStylesMap.keySet();
		for (String key : keySet) {
			Integer value = weddingStylesMap.get(key);
			System.out.println(key + "- You may charge upto " + value + "Rs.");
		}

	}
}
