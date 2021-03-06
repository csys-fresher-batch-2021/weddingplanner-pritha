package in.pritha.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.jupiter.api.Test;

import in.pritha.exception.DBException;

import in.pritha.exception.ServiceException;
import in.pritha.model.Booking;


 class BookingDetailsTestCase {

	/*
	 * This method test with futuredate and futuretime for booking It should return
	 * true
	 */
	@Test
	 void dateTimevalidateTestCase1()  {
		Booking booking = new Booking("pritha",LocalDate.of(2021, 05, 21), LocalTime.of(14, 47, 33),"chennai");
		boolean valid;
		try {
			valid = BookingManager.validateBooking(booking);
			assertTrue(valid);
		} catch (ServiceException e) {
			e.getMessage();
			e.printStackTrace();
		}
		
		
	}
	
	/*
	 * This method test with pastdate and pasttime for booking It should return
	 * false
	 */
	@Test
	 void dateTimevalidateTestCase2()  {
		Booking booking= new Booking("karthi",LocalDate.of(2021, 05, 17), LocalTime.of(21, 47, 33),"chennai");
		Exception exception = assertThrows(ServiceException.class, () -> {
			boolean valid = BookingManager.validateBooking(booking);
			assertFalse(valid);
	    });
		assertEquals("Your Entered Date/time is incorrect", exception.getMessage());
		
	}

	/*
	 * This method test with currentdate and currenttime for booking It should
	 * return false
	 */
	@Test
	 void dateTimevalidateTestCase3()  {
		Booking booking = new Booking("nishanth",LocalDate.of(2021, 05, 19), LocalTime.of(21, 51, 33),"chennai");
		Exception exception = assertThrows(ServiceException.class, () -> {
			boolean valid = BookingManager.validateBooking(booking);
			assertFalse(valid);
	    });
		assertEquals("Your Entered Date/time is incorrect", exception.getMessage());
		
	}

	/*
	 * This method test with futuredate and pasttime for booking It should return
	 * false
	 */
	@Test
	 void dateTimevalidateTestCase4()  {
		Booking booking = new Booking("gayathri",LocalDate.of(2021, 05, 19), LocalTime.of(21, 47, 33),"chennai");
		Exception exception = assertThrows(ServiceException.class, () -> {
			boolean valid = BookingManager.validateBooking(booking);
			assertFalse(valid);
	    });
		assertEquals("Your Entered Date/time is incorrect", exception.getMessage());
		
		
	}

	/*
	 * This method test with futuredate and currenttime for booking It should return
	 * false
	 */
	@Test
	 void dateTimevalidateTestCase5() {
		Booking booking = new Booking("suresh",LocalDate.of(2021, 05, 19), LocalTime.of(21, 50, 30),"chennai");
		Exception exception = assertThrows(ServiceException.class, () -> {
			boolean valid = BookingManager.validateBooking(booking);
			assertFalse(valid);
	    });
		assertEquals("Your Entered Date/time is incorrect", exception.getMessage());
	}

	/*
	 * This method test with pastdate and futuretime for booking It should return
	 * false
	 */
	@Test
	 void dateTimevalidateTestCase6()  {
		Booking booking = new Booking("pravin",LocalDate.of(2020, 05, 19), LocalTime.of(22, 47, 33),"chennai");
		Exception exception = assertThrows(ServiceException.class, () -> {
			boolean valid = BookingManager.validateBooking(booking);
			assertFalse(valid);
	    });
		assertEquals("Your Entered Date/time is incorrect", exception.getMessage());
		
	}

	/*
	 * This method test with pastdate and currenttime for booking It should return
	 * false
	 */
	@Test
	 void dateTimevalidateTestCase7() throws ServiceException, DBException {
		Booking booking = new Booking("prasath",LocalDate.of(2020, 05, 19), LocalTime.of(21, 50, 33),"chennai");
		Exception exception = assertThrows(ServiceException.class, () -> {
			boolean valid = BookingManager.validateBooking(booking);
			assertFalse(valid);
	    });
		assertEquals("Your Entered Date/time is incorrect", exception.getMessage());
	}

}