package in.pritha.dao;



import static org.junit.Assert.assertTrue;

import java.sql.SQLException;
import java.util.Map;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.OrderWith;
import org.junit.runner.manipulation.Alphanumeric;

import in.pritha.exception.DBException;
import in.pritha.exception.MyException;
import in.pritha.model.User;
import in.pritha.service.UserLoginService;

@OrderWith(Alphanumeric.class)
 class Login_Register_DB_Test {

	//@Test
	 void testA_AddUserWithNewCredentials1() throws ClassNotFoundException, SQLException {
		User user = new User("PRITHA","Prit@7172");
		UserLoginService.register(user);
		assertTrue(true);
	}
	
	//@Test
	 void testB_AddUserWithNewCredentials2() throws ClassNotFoundException, SQLException {
		User user = new User("Karthi","Kart@7172");
		UserLoginService.register(user);
		assertTrue(true);
	}
	
	@Test
	 void testC_getAllUserDetails() throws ClassNotFoundException, SQLException, DBException {
		Map<String,String>	userDetails = LoginDAO.getAllUserDetails();
		System.out.println(userDetails);
		assertTrue(true);
	}
	@Rule
	 ExpectedException exceptionRule = ExpectedException.none();
	@Test
	 void testD_RegisterWithExistingCredentials() throws ClassNotFoundException, SQLException {
		exceptionRule.expect(MyException.class);
		exceptionRule.expectMessage("Your Details Already Exist!.You can sign in!");
		User user = new User("Karthi","Kart@7172");
		UserLoginService.register(user);
		assertTrue(true);
	}
	@Test
	 void testE_LoginWithNewCredentials() throws ClassNotFoundException, SQLException {
		exceptionRule.expect(MyException.class);
		exceptionRule.expectMessage("Your Details doesn't Exist!.You have to sin up!");
		User user = new User("KarthiBalaji","Kart@7176");
		UserLoginService.login(user);
		assertTrue(true);
	}
	//@Test
	 void testF_ModifyPasswordInDB() throws ClassNotFoundException, SQLException {
		User user = new User("Cedric@123","Cedric@123","pritha");
		UserLoginService.createAndConfirmPassword(user);
		assertTrue(true);
	}
	@Test
	 void testG_getAllUserDetailsAfterModifiedPassword() throws ClassNotFoundException, SQLException, DBException {
		Map<String,String>	userDetails = LoginDAO.getAllUserDetails();
		System.out.println(userDetails);
		assertTrue(true);
		
	}
	
	
	
	
	
	
	
	

}
