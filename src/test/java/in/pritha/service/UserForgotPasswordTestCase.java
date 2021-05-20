package in.pritha.service;

import static org.junit.Assert.*;

import java.sql.SQLException;


import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import in.pritha.exception.MyException;
import in.pritha.model.User;

 class UserForgotPasswordTestCase {
	
	//TestCases for valid Created passwords
	/**
	 * This method tests with valid password and it should return true
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * @throws MyException
	 */
	@Test
	 void testA_WithValidCreatedPassword() throws ClassNotFoundException, SQLException  {
		//User(create password, confirm pasword, usersername)
		try {
			User user = new User("Prit@7172","Prit@7172","pritha");
			boolean isValidCreatedPassword = UserLoginService.createAndConfirmPassword(user);
			assertTrue(isValidCreatedPassword);
		} catch (MyException e) {
			e.printStackTrace();
		}
	}
	@Rule
	 ExpectedException exceptionRule = ExpectedException.none();
	/**
	 * This method tests with invalid password and it should throw exceptiom
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * @throws MyException
	 */
	@Test
	 void testB_WithInValidCreatedPassword() throws ClassNotFoundException, SQLException {
		//User(create password, confirm pasword, usersername)
		try {
			//exceptionRule.expect(MyException.class);
			//exceptionRule.expectMessage("Your Password must be like this eg.Prit@7172");
			User user = new User("  ","  ","pritha");
			UserLoginService.createAndConfirmPassword(user);
			fail();
		} catch (MyException e) {
			//e.printStackTrace();
			assertEquals("Your Password must be like this eg.Prit@7172",e.getMessage());
		}
	}
	/**
	 * This method tests with unmatched password and it should throw exceptiom
	 * @throws MyException
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	@Test
	 void testC_WithUnMatchedPassword() throws MyException, ClassNotFoundException, SQLException {
		//User(create password, confirm pasword, usersername)
		try {
			//exceptionRule.expect(MyException.class);
			//exceptionRule.expectMessage("Created and Confirmed Password doesn't match");
			User user = new User("Prit@7172","Prit@7173","pritha");
			UserLoginService.createAndConfirmPassword(user);
		} catch (MyException e) {
			assertEquals("Created and Confirmed Password doesn't match",e.getMessage());
			e.printStackTrace();
		}
	}
	/**
	 * This method tests with matched password and it should return true
	 * @throws MyException
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	@Test
	 void testD_WithMatchedPassword() throws MyException, ClassNotFoundException, SQLException {
		//User(create password, confirm pasword, usersername)
		User user = new User("Prit@7172","Prit@7172","pritha");
		boolean isPasswordMatched = UserLoginService.createAndConfirmPassword(user);
		assertTrue(isPasswordMatched);
	}
	
}
