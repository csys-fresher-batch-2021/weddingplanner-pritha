package in.pritha.service;





import in.pritha.dao.WeddingAppDAO;
import in.pritha.exception.DBException;
import in.pritha.exception.ServiceException;
import in.pritha.model.WeddingStyle;

public class BudgetEstimationService {

	
	private BudgetEstimationService() {
		
	}
	/**
	 * It calculates the for the items added in cart
	 * @param wed
	 * @return wed
	 * @throws ServiceException
	 */
	public static int fareEstimation(WeddingStyle wed) throws ServiceException {
		int fare = 0;
			
			try {
				Integer package1 = WeddingAppDAO.getAllWeddingStyles().get(wed.getWeddingStyles());
				
				Integer package2 = WeddingAppDAO.getAllWeddingLocations().get(wed.getWeddingLocations());
				
				Integer package3 = WeddingAppDAO.getAllFoodtypes().get(wed.getFoodType());
				  
				Integer package4 = WeddingAppDAO.getAllGuestCount().get(wed.getguestCount());
				  
				   Integer package5 = WeddingAppDAO.getDecortypes().get(wed.getdecorType());
				    
				   fare= fare + package1 + package2 + package3 + package4 + package5;
				 
				
				
			} catch (DBException | NullPointerException e) {
				e.printStackTrace();
				throw new ServiceException("Can't update fare");
				
			}
		return fare;
	}
	
	

}
