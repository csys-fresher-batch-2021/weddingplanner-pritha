package in.pritha.service;

import static org.junit.Assert.assertEquals;

import java.util.Map;

import org.junit.Test;

import in.pritha.service.WeddingStyleDisplay;

public class WeddingStyleDisplayTestCase {

	/**
	 * It will show all the lists of Wedding Style Types stored in HashMap
	 */
	@Test
	public void weddingStylesListDisplay() {
		Map<String, Integer> weddingStyles = WeddingStyleDisplay.getWeddingStyles();
		assertEquals(5, weddingStyles.size());
	}

}
