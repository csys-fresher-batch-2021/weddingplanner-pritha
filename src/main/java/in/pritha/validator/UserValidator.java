package in.pritha.validator;
import in.pritha.exception.MyException;


import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import in.pritha.service.UserLoginService;

public class UserValidator {
	
	public static boolean isExistingUser(String userName , String passWord) {
		boolean loggedInUser=false;
		if(StringValidator.isValidString(userName) && UserValidator.isvalidPassWord(passWord)){
			Set<String> keys = UserLoginService.getUserLists().keySet();
			for (String key : keys) {
			String value = UserLoginService.getUserLists().get(key);
			if (userName.toUpperCase().equals(key) && passWord.equals(value)) { // to avoid case sensitive
				loggedInUser = true;
				break;
			}
			}
		}
		else {
			throw new MyException("Entered details are invalid");
		}
	return loggedInUser;
		
	}
	
	public static boolean isvalidPassWord(String passWord) {
		// Regex to check valid password.
        String regex = "^(?=.*[0-9])"
                + "(?=.*[a-z])(?=.*[A-Z])"
                + "(?=.*[@#$%^&+=])"
                + "(?=\\S+$).{8,20}$";

  
        // Compile the ReGex
        Pattern p = Pattern.compile(regex);
  
        // If the password is empty
        // return false
        if (passWord == null) {
            return false;
        }
        // Pattern class contains matcher() method
        // to find matching between given password
        // and regular expression.
        Matcher m = p.matcher(passWord);
  
        // Return if the password
        // matched the ReGex
        return m.matches();
	}

	public static boolean isMatchedPassword(String createPassword, String confirmPassword) throws MyException {
		boolean isEqual = false;
		if(UserValidator.isvalidPassWord(createPassword) && UserValidator.isvalidPassWord(confirmPassword)) {
			if(createPassword.equals(confirmPassword)) {
			isEqual = true;
			}
			else {
			MyException me =new MyException("Created and Confirmed Password doesn't match");
            throw me; 
			}
		}
		else {
			MyException me =new MyException("Your Password must be like this eg.Prit@7172");
            throw me; 
		}
		
	return isEqual;
}
	
}
