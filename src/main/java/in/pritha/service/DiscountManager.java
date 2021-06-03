package in.pritha.service;

import in.pritha.dao.DiscountDAO;
import in.pritha.dao.PaymentDAO;
import in.pritha.exception.DBException;
import in.pritha.exception.ServiceException;
import in.pritha.model.Discount;

public class DiscountManager {

	public static Integer checkEligibilityForDiscount(String loggedInUserName) throws ServiceException {
		Integer earnedCoins=null;
		try {
			System.out.println("call dao to check");
			earnedCoins=DiscountDAO.countEarnedCoins(loggedInUserName);
		} catch (DBException e) {
			e.printStackTrace();
			e.getMessage();
			throw new ServiceException(e,"cant fetch earned coins");
			
		}
		
		return earnedCoins;
		
	}
	public static boolean updateDiscountDetails(Discount discount) throws ServiceException {
		boolean isDiscountDetailsAdded = false;
		try {
			System.out.println("updated");
			DiscountDAO.updateDiscountDetails(discount.getUsername());
			isDiscountDetailsAdded = true;
		} catch (DBException e) {
			e.printStackTrace();
			e.getMessage();
			throw new ServiceException(e,"Can't add payment details");
			
		}
		return isDiscountDetailsAdded;
		
	}

	

}
