package in.pritha.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import in.pritha.dao.RegisterDAO;
import in.pritha.exception.MyException;
import in.pritha.model.User;
import in.pritha.validator.UserValidator;


public class UserLoginService{
	
	
	
	//1-Validator
	//2-db
	//3-sendNotification
	
	public static boolean register(User user) throws ClassNotFoundException, SQLException {
		boolean validUser = true;
		//validate it
		if(!(UserValidator.isExistingUser(user.getuserName(),user.getpassWord()))){
			validUser=false;
			RegisterDAO.addUser(user.getuserName(), user.getpassWord());
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
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public static boolean login(User user) throws ClassNotFoundException, SQLException {
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
	 */
	public static Map<String, String> getUserLists() {
		Map<String, String> allUserDetails = null;
		try {
			allUserDetails= RegisterDAO.getAllUserDetails();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Can't fetch user details");
		}
		return allUserDetails;
	}

	public static boolean createAndConfirmPassword(User user) throws MyException, ClassNotFoundException, SQLException{
		boolean isPasswordMatched = false;
		
			if(UserValidator.isMatchedPassword(user.getCreatePassword(),user.getConfirmPassword())) {
		
					RegisterDAO.modifyUserPassWord(user.getuserName(), user.getConfirmPassword());
					isPasswordMatched = true;
				} 
				
		
		return isPasswordMatched;
	}


}
