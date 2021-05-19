package in.pritha.service;



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.SQLException;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import in.pritha.exception.MyException;
import in.pritha.exception.ServiceException;
import in.pritha.model.User;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
 class UserLoginTestCase {
	//TestCases for Username
	/**
	 * This method tests with small case username
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	@Test
	@Order(1)
	 void testA_UsernameWithSmallCase() {
		User user = new User("pritha","Prit@7172");
		boolean isLoggedInUser;
		try {
			isLoggedInUser = UserLoginService.login(user);
			assertTrue(isLoggedInUser);
		} catch (ServiceException e) {
			
			e.printStackTrace();
		}
		
	}
	/**
	 * This method tests with mixed case username
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	@Test
	@Order(2)
	 void testB_UsernameWithMixedCase()  {
		User user = new User("PRitHA","Prit@7172");
		boolean isLoggedInUser;
		try {
			isLoggedInUser = UserLoginService.login(user);
			assertTrue(isLoggedInUser);
		} catch (ServiceException e) {
			
			e.printStackTrace();
		}
		
	}
	/**
	 * This method tests with uppercase username
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	@Test
	@Order(3)
	 void testC_UsernameWithUpperCase() {
		User user = new User("PRITHA","Prit@7172");
		boolean isLoggedInUser;
		try {
			isLoggedInUser = UserLoginService.login(user);
			assertTrue(isLoggedInUser);
		} catch (ServiceException e) {
		
			e.printStackTrace();
		}
		
	}
	//Test Cases for password
	/**
	 * This method tests password without small case
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	
	@Test
	@Order(4)
	 void testD_PasswordWithoutSmallCase() {
		User user = new User("PRITHA","prit@7172");
		Exception exception = assertThrows(MyException.class, () -> {
			boolean isLoggedInUser = UserLoginService.login(user);
			assertFalse(isLoggedInUser);
	    });
		assertEquals("Entered details are invalid", exception.getMessage());
		
		
	}
	/**
	 * This method tests password without special characters 
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	@Test
	@Order(5)
	 void testE_PasswordWithoutSpecialCharacters() {
		User user = new User("PRITHA","Prit7172");
		Exception exception = assertThrows(MyException.class, () -> {
			boolean isLoggedInUser = UserLoginService.login(user);
			assertFalse(isLoggedInUser);
	    });
		assertEquals("Entered details are invalid", exception.getMessage());
		
	}
	/**
	 * This method tests password without numbers
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	@Test
	@Order(6)
	 void testF_PasswordWithoutNumbers()  {
		User user = new User("PRITHA","pritHA@HI");
		Exception exception = assertThrows(MyException.class, () -> {
			boolean isLoggedInUser = UserLoginService.login(user);
			assertFalse(isLoggedInUser);
	    });
		assertEquals("Entered details are invalid", exception.getMessage());
		
		
		
	}
	//Test Cases for checking existing and new credentials
	/**
	 * This method tests with existing credentials
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	@Test
	@Order(7)
	 void testG_WithExistingUserName()  {
		User user = new User("PRITHA","Prit@7172");
		boolean isLoggedInUser;
		try {
			isLoggedInUser = UserLoginService.login(user);
			assertTrue(isLoggedInUser);
		} catch (ServiceException e) {
			
			e.printStackTrace();
		}
		
	}
	/**
	 * This method tests with new credentials
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	@Test
	@Order(8)
	 void testH_WithNewUserName(){
		User user = new User("Nishanth","prit12A@HI");
		Exception exception = assertThrows(MyException.class, () -> {
			boolean isLoggedInUser = UserLoginService.login(user);
			assertFalse(isLoggedInUser);
	    });
		assertEquals("Your Details doesn't Exist!.You have to sin up!", exception.getMessage());
		

	}
	//TestCases for checking (username-password) match
	/**
	 * This method tests with correct username and incorrect password
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	@Test
	@Order(9)
	 void testI_WithCorrectUsernameAndIncorrectPassword() {
		User user = new User("PRITHA","Prit@7173");
		Exception exception = assertThrows(MyException.class, () -> {
			boolean isLoggedInUser = UserLoginService.login(user);
			assertFalse(isLoggedInUser);
	    });
		assertEquals("Your Details doesn't Exist!.You have to sin up!", exception.getMessage());
		
		
	}
	/**
	 * This method tests with correct inusername and correct password
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	@Test
	@Order(10)
	 void testJ_WithInCorrectUsernameAndcorrectPassword()  {
		User user = new User("PrithaPadmanathan","Prit@7172");
		Exception exception = assertThrows(MyException.class, () -> {
			UserLoginService.login(user);			
	    });
		assertEquals("Your Details doesn't Exist!.You have to sin up!", exception.getMessage());
		
	}
	//TestCases for Invalid credentials
	/**
	 * This method tests with invalid username and invalid password
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	@Test
	@Order(11)
	 void testK_WithInValidCredentials()  {
		User user = new User("Pr@123","pritha");
		Exception exception = assertThrows(MyException.class, () -> {
			boolean isLoggedInUser = UserLoginService.login(user);
			assertFalse(isLoggedInUser);
	    });
		assertEquals("Entered details are invalid", exception.getMessage());
		
		
	}
	/**
	 * This method tests with null username and null password
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	@Test
	@Order(12)
	 void testL_WithInValidCredentials() {
		User user = new User(" "," ");
		Exception exception = assertThrows(NullPointerException.class, () -> {
			boolean isLoggedInUser = UserLoginService.login(user);
			assertFalse(isLoggedInUser);
	    });
		assertEquals("Invalid input", exception.getMessage());
		
	
	}
	
	

}
