package in.pritha.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Map;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import in.pritha.model.WeddingStyle;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class Display_AddWeddingStyleTestCase {

	/**
	 * This testcase will get all the lists of Wedding Style Types stored in HashMap
	 * It tests the number of wedding styles availablity in HashMap
	 */
	
	@Test
	@Order(1)
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
	@Order(2)
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
	
	@Test
	@Order(3)
	public void testC_AddWeddingStylesWithExistingStyleName() {
		
		WeddingStyle obj = new WeddingStyle("Modern Wedding",60000);		
		
		Exception exception = assertThrows(RuntimeException.class, () -> {
			WeddingStylesService.addWeddingStyles(obj);
	    });
		assertEquals("This Wedding Style Name Already Exists!", exception.getMessage());

	}

	/**
	 * This testcase will add the new Wedding Style to HashMap with valid wedding
	 * style. Then, it tests the number of wedding styles availablity in HashMap
	 */
	
	@Test
	@Order(4)
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
	@Order(5)
	public void testE_AddWeddingStylesWithInvalidInput() {
		WeddingStyle obj = new WeddingStyle("  ", 0);
		Exception exception = assertThrows(NullPointerException.class, () -> {
			WeddingStylesService.addWeddingStyles(obj);
	    });
		assertEquals("Invalid input", exception.getMessage());
		

	}

}
