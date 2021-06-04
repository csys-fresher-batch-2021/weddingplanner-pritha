package in.pritha.service;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import in.pritha.exception.ServiceException;
import in.pritha.model.WeddingStyle;

public class BudgetEstimationTestCase {
	
	
	@Test
	 void testingWithValidInput() {
		WeddingStyle wed = new WeddingStyle("Traditional Wedding","Hotel","Buffet","500","Under the Sea");
		int budget;
		try {
			budget = BudgetEstimationService.fareEstimation(wed);
			assertEquals(300000,budget);
		} catch (ServiceException e) {
			e.getMessage();
			e.printStackTrace();
		} }
		
		
	

}

