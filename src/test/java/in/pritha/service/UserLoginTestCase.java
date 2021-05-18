package in.pritha.service;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.OrderWith;
import org.junit.runner.manipulation.Alphanumeric;

import in.pritha.exception.MyException;
import in.pritha.model.User;
@OrderWith(Alphanumeric.class)
public class UserLoginTestCase {
	//TestCases for Username
	/**
	 * This method tests with small case username
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	@Test
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
	@Rule
	public ExpectedException exceptionRule = ExpectedException.none();
	@Test
	public void testD_PasswordWithoutSmallCase() throws ClassNotFoundException, SQLException {
		exceptionRule.expect(MyException.class);
		exceptionRule.expectMessage("Entered details are invalid");
		User user = new User("PRITHA","prit@7172");
		boolean isLoggedInUser = UserLoginService.login(user);
		assertFalse(isLoggedInUser);
	}
	/**
	 * This method tests password without special characters 
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	@Test
	public void testE_PasswordWithoutSpecialCharacters() throws ClassNotFoundException, SQLException {
		exceptionRule.expect(MyException.class);
		exceptionRule.expectMessage("Entered details are invalid");
		User user = new User("PRITHA","Prit7172");
		boolean isLoggedInUser = UserLoginService.login(user);
		assertFalse(isLoggedInUser);
	}
	/**
	 * This method tests password without numbers
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	@Test
	public void testF_PasswordWithoutNumbers() throws ClassNotFoundException, SQLException {
		exceptionRule.expect(MyException.class);
		exceptionRule.expectMessage("Entered details are invalid");
		User user = new User("PRITHA","pritHA@HI");
		boolean isLoggedInUser = UserLoginService.login(user);
		assertFalse(isLoggedInUser);
	}
	//Test Cases for checking existing and new credentials
	/**
	 * This method tests with existing credentials
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	@Test
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
	public void testH_WithNewUserName() throws ClassNotFoundException, SQLException {
		exceptionRule.expect(MyException.class);
		exceptionRule.expectMessage("Your Details doesn't Exist!.You have to sin up!");
		User user = new User("Nishanth","prit12A@HI");
		boolean isLoggedInUser = UserLoginService.login(user);
		assertFalse(isLoggedInUser);
	}
	//TestCases for checking (username-password) match
	/**
	 * This method tests with correct username and incorrect password
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	@Test
	public void testI_WithCorrectUsernameAndIncorrectPassword() throws ClassNotFoundException, SQLException {
		exceptionRule.expect(MyException.class);
		exceptionRule.expectMessage("Your Details doesn't Exist!.You have to sin up!");
		User user = new User("PRITHA","Prit@7173");
		boolean isLoggedInUser = UserLoginService.login(user);
		assertFalse(isLoggedInUser);
	}
	/**
	 * This method tests with correct inusername and correct password
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	@Test
	public void testJ_WithInCorrectUsernameAndcorrectPassword() throws ClassNotFoundException, SQLException {
		exceptionRule.expect(MyException.class);
		exceptionRule.expectMessage("Your Details doesn't Exist!.You have to sin up!");
		User user = new User("PrithaPadmanathan","Prit@7172");
		boolean isLoggedInUser = UserLoginService.login(user);
		assertFalse(isLoggedInUser);
	}
	//TestCases for Invalid credentials
	/**
	 * This method tests with invalid username and invalid password
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	@Test
	public void testK_WithInValidCredentials() throws ClassNotFoundException, SQLException {
		exceptionRule.expect(MyException.class);
		exceptionRule.expectMessage("Entered details are invalid");
		User user = new User("Pr@123","pritha");
		boolean isLoggedInUser = UserLoginService.login(user);
		assertFalse(isLoggedInUser);
	}
	/**
	 * This method tests with null username and null password
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	@Test
	public void testL_WithInValidCredentials() throws ClassNotFoundException, SQLException {
		exceptionRule.expect(NullPointerException.class);
		exceptionRule.expectMessage("Invalid input");
		User user = new User(" "," ");
		boolean isLoggedInUser = UserLoginService.login(user);
		assertFalse(isLoggedInUser);
	}
	
	

}
