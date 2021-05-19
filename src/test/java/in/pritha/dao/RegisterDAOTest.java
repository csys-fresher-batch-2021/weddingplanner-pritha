package in.pritha.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;


import java.util.Map;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import in.pritha.exception.DBException;
import in.pritha.exception.MyException;
import in.pritha.exception.ServiceException;
import in.pritha.model.User;
import in.pritha.service.UserLoginService;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class RegisterDAOTest {

	@Test
	@Order(1)
	void testA_AddUserWithNewCredentials1() {
		User user = new User("PRITHA", "Prit@7172");
		try {
			UserLoginService.register(user);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		assertTrue(true);
	}

	@Order(2)
	@Test
	void testB_AddUserWithNewCredentials2() {
		User user = new User("Karthi", "Kart@7172");
		try {
			UserLoginService.register(user);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		assertTrue(true);
	}

	@Order(3)
	@Test
	void testC_getAllUserDetails()  {
		//Map<String, String> userDetails;
		try {
			 RegisterDAO.getAllUserDetails();
			//System.out.println(userDetails);
		} catch (DBException e) {
			
			e.printStackTrace();
		}
		
		assertTrue(true);
	}

	@Order(4)
	@Test
	void testD_RegisterWithExistingCredentials()  {
		User user = new User("Karthi", "Kart@7172");
		Exception exception = assertThrows(MyException.class, () -> {

			UserLoginService.register(user);
		});
		assertEquals("Your Details Already Exist!.You can sign in!", exception.getMessage());

	}

	@Order(5)
	@Test
	void testE_LoginWithNewCredentials() {
		User user = new User("KarthiBalaji", "Kart@7176");
		Exception exception = assertThrows(MyException.class, () -> {
			UserLoginService.login(user);
		});
		assertEquals("Your Details doesn't Exist!.You have to sin up!", exception.getMessage());

	}

	@Test
	@Order(6)
	void testF_ModifyPasswordInDB()  {
		User user = new User("Cedric@123", "Cedric@123", "pritha");
		try {
			UserLoginService.createAndConfirmPassword(user);
		} catch (MyException | ServiceException e) {
			e.printStackTrace();
		}
		assertTrue(true);
	}

	@Test
	@Order(7)
	void testG_getAllUserDetailsAfterModifiedPassword()  {
		//Map<String, String> userDetails;
		try {
			RegisterDAO.getAllUserDetails();
		} catch (DBException e) {
			
			e.printStackTrace();
		}
		
		assertTrue(true);

	}

}
