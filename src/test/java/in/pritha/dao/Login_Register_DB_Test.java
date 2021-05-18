package in.pritha.dao;



import java.sql.SQLException;
import java.util.Map;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.OrderWith;
import org.junit.runner.manipulation.Alphanumeric;

import in.pritha.exception.MyException;
import in.pritha.model.User;
import in.pritha.service.UserLoginService;

@OrderWith(Alphanumeric.class)
public class Login_Register_DB_Test {

	//@Test
	public void testA_AddUserWithNewCredentials1() throws ClassNotFoundException, SQLException {
		User user = new User("PRITHA","Prit@7172");
		UserLoginService.register(user);
	}
	
	//@Test
	public void testB_AddUserWithNewCredentials2() throws ClassNotFoundException, SQLException {
		User user = new User("Karthi","Kart@7172");
		UserLoginService.register(user);
	}
	
	@Test
	public void testC_getAllUserDetails() throws ClassNotFoundException, SQLException {
		Map<String,String>	userDetails = LoginDAO.getAllUserDetails();
		System.out.println(userDetails);
		
	}
	@Rule
	public ExpectedException exceptionRule = ExpectedException.none();
	@Test
	public void testD_RegisterWithExistingCredentials() throws ClassNotFoundException, SQLException {
		exceptionRule.expect(MyException.class);
		exceptionRule.expectMessage("Your Details Already Exist!.You can sign in!");
		User user = new User("Karthi","Kart@7172");
		UserLoginService.register(user);
	}
	@Test
	public void testE_LoginWithNewCredentials() throws ClassNotFoundException, SQLException {
		exceptionRule.expect(MyException.class);
		exceptionRule.expectMessage("Your Details doesn't Exist!.You have to sin up!");
		User user = new User("KarthiBalaji","Kart@7176");
		UserLoginService.login(user);
	}
	//@Test
	public void testF_ModifyPasswordInDB() throws ClassNotFoundException, SQLException {
		User user = new User("Cedric@123","Cedric@123","pritha");
		UserLoginService.createAndConfirmPassword(user);
	}
	@Test
	public void testG_getAllUserDetailsAfterModifiedPassword() throws ClassNotFoundException, SQLException {
		Map<String,String>	userDetails = LoginDAO.getAllUserDetails();
		System.out.println(userDetails);
		
	}
	
	
	
	
	
	
	
	

}
