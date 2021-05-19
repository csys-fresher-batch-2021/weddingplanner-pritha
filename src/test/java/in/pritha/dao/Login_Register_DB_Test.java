package in.pritha.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.sql.SQLException;
import java.util.Map;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import in.pritha.exception.MyException;
import in.pritha.model.User;
import in.pritha.service.UserLoginService;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class Login_Register_DB_Test {

	@Test
	@Order(1)
	public void testA_AddUserWithNewCredentials1() throws ClassNotFoundException, SQLException {
		User user = new User("PRITHA","Prit@7172");
		UserLoginService.register(user);
	}
	@Order(2)
	@Test
	public void testB_AddUserWithNewCredentials2() throws ClassNotFoundException, SQLException {
		User user = new User("Karthi","Kart@7172");
		UserLoginService.register(user);
	}
	@Order(3)
	@Test
	public void testC_getAllUserDetails() throws ClassNotFoundException, SQLException {
		Map<String,String>	userDetails = RegisterDAO.getAllUserDetails();
		System.out.println(userDetails);
		
	}
	@Order(4)
	@Test
	public void testD_RegisterWithExistingCredentials() throws ClassNotFoundException, SQLException {
		User user = new User("Karthi","Kart@7172");
		Exception exception = assertThrows(MyException.class, () -> {
			UserLoginService.login(user);
	    });
		assertEquals("Your Details Already Exist!.You can sign in!", exception.getMessage());

		UserLoginService.register(user);
	}
	@Order(5)
	@Test
	public void testE_LoginWithNewCredentials() throws ClassNotFoundException, SQLException {
		User user = new User("KarthiBalaji","Kart@7176");
		Exception exception = assertThrows(MyException.class, () -> {
			UserLoginService.login(user);
	    });
		assertEquals("Your Details doesn't Exist!.You have to sin up!", exception.getMessage());

		
	}
	@Test
	@Order(6)
	public void testF_ModifyPasswordInDB() throws ClassNotFoundException, SQLException {
		User user = new User("Cedric@123","Cedric@123","pritha");
		UserLoginService.createAndConfirmPassword(user);
	}
	@Test
	@Order(7)
	public void testG_getAllUserDetailsAfterModifiedPassword() throws ClassNotFoundException, SQLException {
		Map<String,String>	userDetails = RegisterDAO.getAllUserDetails();
		System.out.println(userDetails);
		
	}
	
	
	
	
	
	
	
	

}
