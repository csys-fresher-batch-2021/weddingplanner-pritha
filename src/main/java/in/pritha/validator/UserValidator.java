package in.pritha.validator;

import in.pritha.exception.ServiceException;
import in.pritha.exception.ValidationException;

import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import in.pritha.service.UserService;

public class UserValidator {
	private UserValidator() {
		//private constructor
	}
	
	public static boolean isExistingUser(String userName , String passWord) throws ValidationException {
		boolean loggedInUser=false;
		try {
		if(StringValidator.isValidString(userName) && UserValidator.isvalidPassWord(passWord)){
			Set<String> keys;
			
				keys = UserService.getUserLists().keySet();
			
			for (String key : keys) {
			String value = UserService.getUserLists().get(key);
			if (userName.toUpperCase().equals(key) && passWord.equals(value)) { // to avoid case sensitive
				loggedInUser = true;
				break;
			}
			
			}
		}
		}
		
		 catch (ServiceException e) {
			 e.getMessage();
			 throw new ValidationException(e,"Entered details are invalid");
			
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

	public static boolean isMatchedPassword(String createPassword, String confirmPassword) throws ValidationException {
		boolean isEqual = false;
		if(UserValidator.isvalidPassWord(createPassword) && UserValidator.isvalidPassWord(confirmPassword)) {
			if(createPassword.equals(confirmPassword)) {
			isEqual = true;
			}
			else {
		 throw new ValidationException("Created and Confirmed Password doesn't match");
            
			}
		}
		else {
			throw new ValidationException("Your Password must be like this eg.Prit@7172");
            
		}
		
	return isEqual;
}
	
}
