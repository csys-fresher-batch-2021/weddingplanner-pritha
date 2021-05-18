package in.pritha.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Map;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.OrderWith;
import org.junit.runner.manipulation.Alphanumeric;

import in.pritha.model.WeddingStyle;

@OrderWith(Alphanumeric.class)
public class Display_AddWeddingStyleTestCase {

	/**
	 * This testcase will get all the lists of Wedding Style Types stored in HashMap
	 * It tests the number of wedding styles availablity in HashMap
	 */

	@Test
	public void testA_WeddingStylesListDisplay() {
		Map<String, Integer> weddingStyles = WeddingStylesService.getWeddingStyles();
		// assertEquals(expected,actual)
		assertEquals(5, weddingStyles.size());
	}

	/**
	 * This testcase will add the new Wedding Style to HashMap Then, it tests the
	 * number of wedding styles availablity in HashMap
	 */
	@Test
	public void testB_AddWeddingStylesWithNewStyleName() {
		WeddingStyle obj = new WeddingStyle("Modern Wedding", 60000);
		boolean isAdded = WeddingStylesService.addWeddingStyles(obj);
		assertTrue(isAdded);
		Map<String, Integer> weddingStyles = WeddingStylesService.getWeddingStyles();
		// assertEquals(expected,actual)
		assertEquals(5 + 1, weddingStyles.size());

	}

	/**
	 * This testcase will add the exisiting Wedding Style to HashMap Then, it tests
	 * the number of wedding styles availablity in HashMap- it should throw
	 * exception
	 */
	@Rule
	public ExpectedException exceptionRule = ExpectedException.none();

	@Test
	public void testC_AddWeddingStylesWithExistingStyleName() {
		exceptionRule.expect(RuntimeException.class);
		exceptionRule.expectMessage("This Wedding Style Name Already Exists!");
		WeddingStyle obj = new WeddingStyle("Modern Wedding",60000);
		WeddingStylesService.addWeddingStyles(obj);

	}

	/**
	 * This testcase will add the new Wedding Style to HashMap with valid wedding
	 * style. Then, it tests the number of wedding styles availablity in HashMap
	 */
	@Test
	public void testD_AddWeddingStylesWithValidInput() {
		WeddingStyle obj = new WeddingStyle("Outdoor Wedding", 50000);
		boolean isAdded = WeddingStylesService.addWeddingStyles(obj);
		assertTrue(isAdded);
		Map<String, Integer> weddingStyles = WeddingStylesService.getWeddingStyles();
		// assertEquals(expected,actual)
		assertEquals(6 + 1, weddingStyles.size());
	}

	/**
	 * This testcase will add the new Wedding Style to HashMap with invalid wedding
	 * style and package Then, it tests the number of wedding styles availablity in
	 * HashMap- it should throw exception
	 */
	@Test
	public void testE_AddWeddingStylesWithInvalidInput() {
		exceptionRule.expect(NullPointerException.class);
		exceptionRule.expectMessage("Invalid input");
		WeddingStyle obj = new WeddingStyle("  ", 0);
		WeddingStylesService.addWeddingStyles(obj);

	}

}
