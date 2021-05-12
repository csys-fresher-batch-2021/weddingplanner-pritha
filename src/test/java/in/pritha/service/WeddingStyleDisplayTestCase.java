package in.pritha.service;

import static org.junit.Assert.assertEquals;

import java.util.Map;

import org.junit.Test;

public class WeddingStyleDisplayTestCase {

	/**
	 * This testcase will get all the lists of Wedding Style Types stored in HashMap
	 * It tests the number of wedding styles availablity in HashMap
	 */
	@Test
	public void weddingStylesListDisplay() {
		Map<String, Integer> weddingStyles = WeddingStyleDisplay.getWeddingStyles();
		// assertEquals(expected,actual)
		assertEquals(5, weddingStyles.size());
	}

}
