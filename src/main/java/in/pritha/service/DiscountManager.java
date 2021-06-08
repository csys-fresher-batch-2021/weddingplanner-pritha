package in.pritha.service;

import in.pritha.dao.DiscountDAO;

import in.pritha.exception.DBException;
import in.pritha.exception.ServiceException;
import in.pritha.model.Discount;
import in.pritha.util.Logger;

public class DiscountManager {
	private DiscountManager() {
		
	}

	/**
	 * This method returns the eligibility for disocount
	 * @param loggedInUserName
	 * @return
	 * @throws ServiceException
	 */
	public static Integer checkEligibilityForDiscount(String loggedInUserName) throws ServiceException {
		Integer earnedCoins=null;
		try {
			Logger.println("call dao to check");
			earnedCoins=DiscountDAO.countEarnedCoins(loggedInUserName);
		} catch (DBException e) {
			e.printStackTrace();
			e.getMessage();
			throw new ServiceException(e,"cant fetch earned coins");
			
		}
		
		return earnedCoins;
		
	}
	
	/**
	 * This method update the discount details everytime of the booking of user
	 * They may earn default 100 coins and status=unused
	 * @param discount
	 * @return true if updated
	 * @throws ServiceException
	 */
	public static boolean updateDiscountDetails(Discount discount) throws ServiceException {
		boolean isDiscountDetailsAdded = false;
		try {
			Logger.println("updated");
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
