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
import in.pritha.model.User;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserLoginTestCase {
	//TestCases for Username
	/**
	 * This method tests with small case username
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	@Test
	@Order(1)
	public void testA_UsernameWithSmallCase() throws ClassNotFoundException, SQLException {
		User user = new User("pritha","Prit@7172");
		boolean isLoggedInUser = UserLoginService.login(user);
		assertTrue(isLoggedInUser);
	}
	/**
	 * This method tests with mixed case username
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	@Test
	@Order(2)
	public void testB_UsernameWithMixedCase() throws ClassNotFoundException, SQLException {
		User user = new User("PRitHA","Prit@7172");
		boolean isLoggedInUser = UserLoginService.login(user);
		assertTrue(isLoggedInUser);
	}
	/**
	 * This method tests with uppercase username
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	@Test
	@Order(3)
	public void testC_UsernameWithUpperCase() throws ClassNotFoundException, SQLException {
		User user = new User("PRITHA","Prit@7172");
		boolean isLoggedInUser = UserLoginService.login(user);
		assertTrue(isLoggedInUser);
	}
	//Test Cases for password
	/**
	 * This method tests password without small case
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	
	@Test
	@Order(4)
	public void testD_PasswordWithoutSmallCase() throws ClassNotFoundException, SQLException {
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
	public void testE_PasswordWithoutSpecialCharacters() throws ClassNotFoundException, SQLException {
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
	public void testF_PasswordWithoutNumbers() throws ClassNotFoundException, SQLException {
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
	public void testG_WithExistingUserName() throws ClassNotFoundException, SQLException {
		User user = new User("PRITHA","Prit@7172");
		boolean isLoggedInUser = UserLoginService.login(user);
		assertTrue(isLoggedInUser);
	}
	/**
	 * This method tests with new credentials
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	@Test
	@Order(8)
	public void testH_WithNewUserName() throws ClassNotFoundException, SQLException {
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
	public void testI_WithCorrectUsernameAndIncorrectPassword() throws ClassNotFoundException, SQLException {
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
	public void testJ_WithInCorrectUsernameAndcorrectPassword() throws ClassNotFoundException, SQLException {
		User user = new User("PrithaPadmanathan","Prit@7172");
		Exception exception = assertThrows(MyException.class, () -> {
			boolean isLoggedInUser = UserLoginService.login(user);
			assertFalse(isLoggedInUser);
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
	public void testK_WithInValidCredentials() throws ClassNotFoundException, SQLException {
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
	public void testL_WithInValidCredentials() throws ClassNotFoundException, SQLException {
		User user = new User(" "," ");
		Exception exception = assertThrows(NullPointerException.class, () -> {
			boolean isLoggedInUser = UserLoginService.login(user);
			assertFalse(isLoggedInUser);
	    });
		assertEquals("Invalid input", exception.getMessage());
		
	
	}
	
	

}
