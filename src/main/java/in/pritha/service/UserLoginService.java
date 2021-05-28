package in.pritha.service;

import java.sql.SQLException;

import java.util.Map;

import in.pritha.dao.RegisterDAO;
import in.pritha.exception.DBException;
import in.pritha.exception.MyException;
import in.pritha.exception.ServiceException;
import in.pritha.model.User;
import in.pritha.validator.UserValidator;


public class UserLoginService{
	 private UserLoginService() {
		 //private constructor
	 }
	
	
	
	public static boolean register(User user) throws ServiceException  {
		boolean validUser = true;
		//validate it
		if(!(UserValidator.isExistingUser(user.getuserName(),user.getpassWord()))){
			validUser=false;
			try {
				RegisterDAO.addUser(user.getuserName(), user.getpassWord());
			} catch (DBException e) {
				e.printStackTrace();
				throw new ServiceException("You can't register!.Check your details");
				
			}
		}
		else {
			throw new MyException("Your Details Already Exist!.You can sign in!");
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
	public static boolean login(User user) throws ServiceException  {
		boolean validUser = false;
		//validate it
		if(UserValidator.isExistingUser(user.getuserName(),user.getpassWord())){
			validUser=true;
		}
		else {
			throw new MyException("Your Details doesn't Exist!.You have to sin up!");
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
			allUserDetails= RegisterDAO.getAllUserDetails();
		} catch (DBException e) {
			e.printStackTrace();
			throw new ServiceException("User Details cant be displayed");
		}
		return allUserDetails;
	}

	public static boolean createAndConfirmPassword(User user) throws MyException, ServiceException{
		boolean isPasswordMatched = false;
		
			if(UserValidator.isMatchedPassword(user.getCreatePassword(),user.getConfirmPassword())) {
		
					try {
						RegisterDAO.modifyUserPassWord(user.getuserName(), user.getConfirmPassword());
					} catch (DBException e) {
						e.printStackTrace();
						throw new ServiceException("Password can't changed");
						
					}
					isPasswordMatched = true;
				} 
				
		
		return isPasswordMatched;
	}


}
