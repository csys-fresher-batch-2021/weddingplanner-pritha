package in.pritha.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import in.pritha.dao.BookingDAO;
import in.pritha.exception.DBException;
import in.pritha.exception.ServiceException;
import in.pritha.model.Booking;

import in.pritha.validator.BookingDateTimeValidator;

public class BookingManager {
	private BookingManager() {
	}

	public static boolean validateBooking(Booking booking) throws ServiceException, DBException {
		// 1-validate
		boolean isEligibleToBook = BookingDateTimeValidator.dateTimeValidator(booking.getWeddingDate(), booking.getWeddingTime(), booking.getWeddingLocation());

		if (isEligibleToBook) {
			BookingDAO.addBookingDetails(booking.getBooking_id(),booking.getStatus(),booking.getUserName(),
					booking.getWeddingDate(), booking.getWeddingTime(), booking.getWeddingLocation(),
					booking.getWeddingStyle(), booking.getWeddingStyleLocation(), booking.getWeddingFoodType(),
					booking.getWeddingGuestCount(), booking.getWeddingDecorType());
		} else {
			throw new ServiceException("Can't Book . Check Your Details!");
		}
		return isEligibleToBook;
	}

	public static List<Booking> listBookingDetails(String userName) throws ServiceException {
		List<Booking> bookingDetailsList = new ArrayList<Booking>();
		try {
			// brring from db
			bookingDetailsList = BookingDAO.displayBookingDetails(userName);
		} catch (DBException e) {
			throw new ServiceException("can't display your booking details");
		}

		return bookingDetailsList;

	}
	public static boolean cancelBooking(Integer id,String status,String bookedUsername, String reason) throws ServiceException {
		boolean isCancelled = false;
		try {
		if(BookingDAO.cancelBooking(id, status, bookedUsername, reason)) {
		
			isCancelled = true;
			
		}} catch (DBException e) {
			throw new ServiceException("can't cancel booking");
		}
		

		return isCancelled;

	}

	public static List<Booking> listAllBookingDetails() throws ServiceException {
		List<Booking> bookingDetailsList = new ArrayList<Booking>();
		try {
			// brring from db
			bookingDetailsList = BookingDAO.displayAllBookingDetails();
		} catch (DBException e) {
			throw new ServiceException("can't display all booking details");
		}

		return bookingDetailsList;

	}

	public static Integer generateBookingId(int start, int end) {
		   	Random random = new Random();
		        long fraction = (long) ((end - start + 1 ) * random.nextDouble());
		        return ((int)(fraction + start));
		    
	}

	public static List<Booking> listAllConfirmedBookingDetails() throws ServiceException {
		List<Booking> bookingDetailsList = new ArrayList<Booking>();
		try {
			// brring from db
			bookingDetailsList = BookingDAO.displayAllConfirmedBookingDetails();
		} catch (DBException e) {
			throw new ServiceException("can't display confimed booking details");
		}

		return bookingDetailsList;
		
	}

	public static List<Booking> listAllCancelledBookingDetails() throws ServiceException {
		List<Booking> bookingDetailsList = new ArrayList<Booking>();
		try {
			// brring from db
			bookingDetailsList = BookingDAO.displayAllCancelledBookingDetails();
		} catch (DBException e) {
			throw new ServiceException("can't display cancelled booking details");
		}

		return bookingDetailsList;
		
	}

}
