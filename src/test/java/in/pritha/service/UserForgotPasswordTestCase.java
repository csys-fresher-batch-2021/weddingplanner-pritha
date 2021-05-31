package in.pritha.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;


import in.pritha.exception.ServiceException;
import in.pritha.model.User;

class UserForgotPasswordTestCase {

	// TestCases for valid Created passwords
	/**
	 * This method tests with valid password and it should return true
	 * 
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws MyException
	 */
	@Test
	void testA_WithValidCreatedPassword() {
		// User(create password, confirm pasword, usersername)
		try {
			User user = new User("Prit@7172", "Prit@7172", "pritha");
			boolean isValidCreatedPassword = UserService.createAndConfirmPassword(user);
			assertTrue(isValidCreatedPassword);
		} catch ( ServiceException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method tests with invalid password and it should throw exceptiom
	 * 
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws MyException
	 */
	@Test
	void testB_WithInValidCreatedPassword() {

		try {

			User user = new User("  ", "  ", "pritha");
			UserService.createAndConfirmPassword(user);
			fail();
		} catch (ServiceException e) {
			// e.printStackTrace();
			assertEquals("Your Password must be like this eg.Prit@7172", e.getMessage());
		}
	}

	/**
	 * This method tests with unmatched password and it should throw exceptiom
	 * 
	 * @throws MyException
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	@Test
	void testC_WithUnMatchedPassword() {

		try {

			User user = new User("Prit@7172", "Prit@7173", "pritha");

			UserService.createAndConfirmPassword(user);

		} catch ( ServiceException e) {
			assertEquals("Created and Confirmed Password doesn't match", e.getMessage());
			e.printStackTrace();
		}
	}

	/**
	 * This method tests with matched password and it should return true
	 * 
	 * @throws MyException
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	// @Test
	void testD_WithMatchedPassword() {
		// User(create password, confirm pasword, usersername)
		User user = new User("Prit@7172", "Prit@7172", "pritha");
		boolean isPasswordMatched;
		try {
			isPasswordMatched = UserService.createAndConfirmPassword(user);
			assertTrue(isPasswordMatched);
		} catch ( ServiceException e) {
			e.printStackTrace();
		}
		
	}

}
