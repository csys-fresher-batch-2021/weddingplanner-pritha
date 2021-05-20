package in.pritha.service;


import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

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
		User user = new User("pritha",LocalDate.of(2021, 05, 21), LocalTime.of(23, 47, 33),"chennai");
		boolean valid = BookingService.booking(user);
		// assertExpected(actual)
		assertTrue(valid);
	}
	@Rule
	public ExpectedException exceptionRule = ExpectedException.none();
	/*
	 * This method test with pastdate and pasttime for booking It should return
	 * false
	 */
	@Test
	public void dateTimevalidateTestCase2() throws ServiceException, DBException {
		exceptionRule.expect(MyException.class);
		exceptionRule.expectMessage("Your Entered Date/time is incorrect");
		User user = new User("karthi",LocalDate.of(2021, 05, 17), LocalTime.of(21, 47, 33),"chennai");
		boolean valid = BookingService.booking(user);
		// assertExpected(actual)
		assertFalse(valid);
	}

	/*
	 * This method test with currentdate and currenttime for booking It should
	 * return false
	 */
	@Test
	public void dateTimevalidateTestCase3() throws ServiceException, DBException {
		exceptionRule.expect(MyException.class);
		exceptionRule.expectMessage("Your Entered Date/time is incorrect");
		User user = new User("nishanth",LocalDate.of(2021, 05, 19), LocalTime.of(21, 51, 33),"chennai");
		boolean valid = BookingService.booking(user);
		// assertExpected(actual)
		assertFalse(valid);
	}

	/*
	 * This method test with futuredate and pasttime for booking It should return
	 * false
	 */
	@Test
	public void dateTimevalidateTestCase4() throws ServiceException, DBException {
		exceptionRule.expect(MyException.class);
		exceptionRule.expectMessage("Your Entered Date/time is incorrect");
		User user = new User("gayathri",LocalDate.of(2021, 05, 19), LocalTime.of(21, 47, 33),"chennai");
		boolean valid = BookingService.booking(user);
		// assertExpected(actual)
		assertFalse(valid);
	}

	/*
	 * This method test with futuredate and currenttime for booking It should return
	 * false
	 */
	@Test
	public void dateTimevalidateTestCase5() throws ServiceException, DBException {
		exceptionRule.expect(MyException.class);
		exceptionRule.expectMessage("Your Entered Date/time is incorrect");
		User user = new User("suresh",LocalDate.of(2021, 05, 19), LocalTime.of(21, 50, 30),"chennai");
		boolean valid = BookingService.booking(user);
		// assertExpected(actual)
		assertFalse(valid);
	}

	/*
	 * This method test with pastdate and futuretime for booking It should return
	 * false
	 */
	@Test
	public void dateTimevalidateTestCase6() throws ServiceException, DBException {
		exceptionRule.expect(MyException.class);
		exceptionRule.expectMessage("Your Entered Date/time is incorrect");
		User user = new User("pravin",LocalDate.of(2020, 05, 19), LocalTime.of(22, 47, 33),"chennai");
		boolean valid = BookingService.booking(user);
		// assertExpected(actual)
		assertFalse(valid);
	}

	/*
	 * This method test with pastdate and currenttime for booking It should return
	 * false
	 */
	@Test
	public void dateTimevalidateTestCase7() throws ServiceException, DBException {
		exceptionRule.expect(MyException.class);
		exceptionRule.expectMessage("Your Entered Date/time is incorrect");
		User user = new User("prasath",LocalDate.of(2020, 05, 19), LocalTime.of(21, 50, 33),"chennai");
		boolean valid = BookingService.booking(user);
		// assertExpected(actual)
		assertFalse(valid);
	}

}
