package in.pritha.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.jupiter.api.Test;

import in.pritha.exception.DBException;
import in.pritha.exception.MyException;
import in.pritha.exception.ServiceException;
import in.pritha.model.User;

public class BookingDetailsTestCase {

	/*
	 * This method test with futuredate and futuretime for booking It should return
	 * true
	 */
	@Test
	public void dateTimevalidateTestCase1() throws ServiceException, DBException {
		User user = new User("pritha",LocalDate.of(2021, 05, 21), LocalTime.of(14, 47, 33),"chennai");
		boolean valid = BookingManager.booking(user);
		// assertExpected(actual)
		assertTrue(valid);
	}
	
	/*
	 * This method test with pastdate and pasttime for booking It should return
	 * false
	 */
	@Test
	public void dateTimevalidateTestCase2() throws ServiceException, DBException {
		User user = new User("karthi",LocalDate.of(2021, 05, 17), LocalTime.of(21, 47, 33),"chennai");
		Exception exception = assertThrows(MyException.class, () -> {
			boolean valid = BookingManager.booking(user);
			assertFalse(valid);
	    });
		assertEquals("Your Entered Date/time is incorrect", exception.getMessage());
		
	}

	/*
	 * This method test with currentdate and currenttime for booking It should
	 * return false
	 */
	@Test
	public void dateTimevalidateTestCase3() throws ServiceException, DBException {
		User user = new User("nishanth",LocalDate.of(2021, 05, 19), LocalTime.of(21, 51, 33),"chennai");
		Exception exception = assertThrows(MyException.class, () -> {
			boolean valid = BookingManager.booking(user);
			assertFalse(valid);
	    });
		assertEquals("Your Entered Date/time is incorrect", exception.getMessage());
		
	}

	/*
	 * This method test with futuredate and pasttime for booking It should return
	 * false
	 */
	@Test
	public void dateTimevalidateTestCase4() throws ServiceException, DBException {
		User user = new User("gayathri",LocalDate.of(2021, 05, 19), LocalTime.of(21, 47, 33),"chennai");
		Exception exception = assertThrows(MyException.class, () -> {
			boolean valid = BookingManager.booking(user);
			assertFalse(valid);
	    });
		assertEquals("Your Entered Date/time is incorrect", exception.getMessage());
		
		
	}

	/*
	 * This method test with futuredate and currenttime for booking It should return
	 * false
	 */
	@Test
	public void dateTimevalidateTestCase5() throws ServiceException, DBException {
		User user = new User("suresh",LocalDate.of(2021, 05, 19), LocalTime.of(21, 50, 30),"chennai");
		Exception exception = assertThrows(MyException.class, () -> {
			boolean valid = BookingManager.booking(user);
			assertFalse(valid);
	    });
		assertEquals("Your Entered Date/time is incorrect", exception.getMessage());
	}

	/*
	 * This method test with pastdate and futuretime for booking It should return
	 * false
	 */
	@Test
	public void dateTimevalidateTestCase6() throws ServiceException, DBException {
		User user = new User("pravin",LocalDate.of(2020, 05, 19), LocalTime.of(22, 47, 33),"chennai");
		Exception exception = assertThrows(MyException.class, () -> {
			boolean valid = BookingManager.booking(user);
			assertFalse(valid);
	    });
		assertEquals("Your Entered Date/time is incorrect", exception.getMessage());
		
	}

	/*
	 * This method test with pastdate and currenttime for booking It should return
	 * false
	 */
	@Test
	public void dateTimevalidateTestCase7() throws ServiceException, DBException {
		User user = new User("prasath",LocalDate.of(2020, 05, 19), LocalTime.of(21, 50, 33),"chennai");
		Exception exception = assertThrows(MyException.class, () -> {
			boolean valid = BookingManager.booking(user);
			assertFalse(valid);
	    });
		assertEquals("Your Entered Date/time is incorrect", exception.getMessage());
	}

}