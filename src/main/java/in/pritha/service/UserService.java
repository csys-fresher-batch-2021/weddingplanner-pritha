package in.pritha.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import in.pritha.dao.RegisterDAO;
import in.pritha.dao.UserDAO;
import in.pritha.dao.UserHistoryDAO;
import in.pritha.dto.UserHistoryDTO;
import in.pritha.exception.DBException;

import in.pritha.exception.ServiceException;
import in.pritha.exception.ValidationException;
import in.pritha.model.Booking;
import in.pritha.model.User;

import in.pritha.validator.UserValidator;

public class UserService {
	private UserService() {
		// private constructor
	}

	public static boolean register(User user) throws ServiceException {
		boolean validUser = false;
		// validate it
		try {
			if (!(UserValidator.isExistingUser(user.getuserName(), user.getpassWord()))) {
				validUser =true;
				try {
					RegisterDAO.addUser(user.getuserName(), user.getpassWord());
				} catch (DBException e) {
					e.printStackTrace();
					throw new ServiceException("You can't register!.Check your details");

				}
			} else {
				throw new ServiceException("Your Details Already Exist!.You can sign in!");
			}
		}catch(ValidationException e) {
			e.getMessage();
			throw new ServiceException(e,"Your Details Already Exist!.You can sign in!");
			
		}
		return validUser;
	}

	/**
	 * This method used to search the details of the user In case of sign up, it
	 * will check whether the username and password stored or not
	 * 
	 * @param userName
	 * @param passWord
	 * @return true if the details exists in userListMap
	 * @throws ServiceException
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public static boolean login(User user) throws ServiceException {
		boolean validUser = false;
		// validate it
		try {
			if (UserValidator.isExistingUser(user.getuserName(), user.getpassWord())) {
				validUser = true;
			} else {
				throw new ServiceException("Your Details doesn't Exist!.You have to sin up!");
			}
		} catch (ValidationException e) {
			e.getMessage();
			throw new ServiceException(e,"Your Details doesn't Exist!.You have to sin up!");
		}
		return validUser;
	}

	/**
	 * This method gets all the available users with their passwords
	 * 
	 * @return weddingStylesMap
	 * @throws ServiceException
	 */
	public static Map<String, String> getUserLists() throws ServiceException {
		Map<String, String> allUserDetails = null;
		try {
			allUserDetails = RegisterDAO.getAllUserDetails();
		} catch (DBException e) {
			e.printStackTrace();
			throw new ServiceException("User Details cant be displayed");
		}
		return allUserDetails;
	}

	public static boolean createAndConfirmPassword(User user) throws  ServiceException{
		boolean isPasswordMatched = false;
		try {
			if(UserValidator.isMatchedPassword(user.getCreatePassword(),user.getConfirmPassword())) {
				isPasswordMatched = true;
					RegisterDAO.modifyUserPassWord(user.getuserName(), user.getConfirmPassword());
					} }catch (DBException | ValidationException e) {
						e.printStackTrace();
						throw new ServiceException("Password can't changed");
						
					}
		return isPasswordMatched;
					
		}

	public static List<UserHistoryDTO> listUserDetailsByUsername(String userName) throws ServiceException {
		List<UserHistoryDTO> userHistory=null;
		try {
			userHistory = UserHistoryDAO.findUserHistory(userName);
		} catch (DBException e) {
			e.getMessage();
			e.printStackTrace();
			throw new ServiceException(e,"UserHistory can't be listed");
		}
		return  userHistory;
			 
		 
		
	}

	public static boolean inActivateUser(String logoutUser) throws ServiceException {
		System.out.println("service");
		boolean isInActivated=false;
		try {
			if(UserDAO.deleteUser(logoutUser)) {
				isInActivated = true;
			}
			else {
				throw new ServiceException("can't delete this user");
			}
		} catch (DBException e) {
			e.getMessage();
			e.printStackTrace();
			throw new ServiceException(e,"can't delete this user");
		}
		return isInActivated;
	}

}
