package in.pritha.service;


import in.pritha.dao.BookingDAO;
import in.pritha.exception.DBException;
import in.pritha.exception.ServiceException;
import in.pritha.model.User;
import in.pritha.validator.BookingValidator;

public class BookingService {

	public static boolean booking(User user) throws ServiceException, DBException {
		//1-validate
		boolean isEligibleToBook = BookingValidator.dateTimeValidator(user.getWeddingDate(), user.getWeddingTime(),user.getWeddingLocation());
		//2-add in DB
		if(isEligibleToBook) {
			BookingDAO.addBookingDetails(user.getuserName(), user.getWeddingDate(), user.getWeddingTime(), user.getWeddingLocation());
			}
		else {
			throw new ServiceException("Can't Book . Check Your Details!");
		}
		return isEligibleToBook;
	}
}
