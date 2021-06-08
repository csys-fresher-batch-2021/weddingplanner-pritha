package in.pritha.service;


import java.util.ArrayList;
import java.util.List;

import java.util.Random;



import in.pritha.dao.BookingDAO;
import in.pritha.dao.DiscountDAO;
import in.pritha.dao.PaymentDAO;
import in.pritha.dto.BookingDTO;
import in.pritha.exception.DBException;
import in.pritha.exception.ServiceException;
import in.pritha.exception.ValidationException;
import in.pritha.model.Booking;
import in.pritha.model.Payment;
import in.pritha.util.Logger;
import in.pritha.validator.BookingDateTimeValidator;

public class BookingManager {
	private BookingManager() {
	}
	
	/**
	 * This method used to validate booking details
	 * It calls the validator to validate time and date
	 * If validated, add the booking details to dao
	 * @param booking
	 * @return true if all these steps done
	 * @throws ServiceException
	 */
	public static boolean validateBooking(Booking booking) throws ServiceException{
		// 1-validate
		boolean isEligibleToBook;
		try {
			isEligibleToBook = BookingDateTimeValidator.dateTimeValidator(booking.getWeddingDate(), booking.getWeddingTime(), booking.getWeddingLocation());
			if (isEligibleToBook) {
				BookingDAO.addBookingDetails(booking.getBooking_id(),booking.getStatus(),booking.getUserName(),
						booking.getWeddingDate(), booking.getWeddingTime(), booking.getWeddingLocation(),
						booking.getWeddingStyle(), booking.getWeddingStyleLocation(), booking.getWeddingFoodType(),
						booking.getWeddingGuestCount(), booking.getWeddingDecorType());
				Logger.println(" call Discount dao");
				DiscountDAO.addDiscountDetails(booking.getUserName(),booking.getBooking_id(),booking.getStatus());
			} else {
				
				throw new ServiceException("Can't Book . Check Your Details!");
			}
		
		} catch (ValidationException |DBException e) {
			e.getMessage();
			throw new ServiceException(e,"Can't Book . Check Your Details!");
			
		}

	
		return isEligibleToBook;
	}

	/**
	 * This method list all booking for particular user name
	 * @param userName
	 * @return list of booking details
	 * @throws ServiceException
	 */
	public static List<Booking> listBookingDetails(String userName) throws ServiceException {
		List<Booking> bookingDetailsList = new ArrayList<>();
		try {
			// brring from db
			bookingDetailsList = BookingDAO.displayBookingDetails(userName);
		} catch (DBException e) {
			throw new ServiceException("can't display your booking details");
		}

		return bookingDetailsList;

	}
	
	/**
	 * This method cancel the booking if the user want to do
	 * It calls dao to update the booking details table
	 * @param id
	 * @param status
	 * @param bookedUsername
	 * @param reason
	 * @return true if updated
	 * @throws ServiceException
	 */
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

	/**
	 * This method list all booking details to admin
	 * @return list of booking details
	 * @throws ServiceException
	 */
	public static List<Booking> listAllBookingDetails() throws ServiceException {
		List<Booking> bookingDetailsList = new ArrayList<>();
		try {
			// brring from db
			bookingDetailsList = BookingDAO.displayAllBookingDetails();
		} catch (DBException e) {
			throw new ServiceException("can't display all booking details");
		}

		return bookingDetailsList;

	}

	/**
	 * This method used to generate booking id
	 * @param start
	 * @param end
	 * @return bookingid
	 */
	public static Integer generateBookingId(int start, int end) {
		   	Random random = new Random();
		        long fraction = (long) ((end - start + 1 ) * random.nextDouble());
		        return ((int)(fraction + start));
		    
	}

	/**
	 * This method list all confirmed booking details to admin
	 * @return list of booking details
	 * @throws ServiceException
	 */
	public static List<Booking> listAllConfirmedBookingDetails() throws ServiceException {
		List<Booking> bookingDetailsList = new ArrayList<>();
		try {
			// brring from db
			bookingDetailsList = BookingDAO.displayAllConfirmedBookingDetails();
		} catch (DBException e) {
			throw new ServiceException("can't display confimed booking details");
		}

		return bookingDetailsList;
		
	}
	/**
	 * This method list all cancelled booking details to admin
	 * @return list of booking details
	 * @throws ServiceException
	 */
	public static List<Booking> listAllCancelledBookingDetails() throws ServiceException {
		List<Booking> bookingDetailsList = new ArrayList<>();
		try {
			// brring from db
			bookingDetailsList = BookingDAO.displayAllCancelledBookingDetails();
		} catch (DBException e) {
			throw new ServiceException("can't display cancelled booking details");
		}

		return bookingDetailsList;
		
	}
	/**
	 * This method list all paid booking details to admin
	 * @return list of booking details
	 * @throws ServiceException
	 */
	public static List<Payment> listAllPaidBookingDetails() throws ServiceException {
	List<Payment> paidBookingDetailsList = new ArrayList<>();
	try {
		// brring from db
		paidBookingDetailsList = PaymentDAO.displayAllPaidBookingDetails();
	} catch (DBException e) {
		throw new ServiceException("can't display paid booking details");
	}

	return paidBookingDetailsList;		
		
	}
	/**
	 * This method list count of total number of bookings
	 * @return number of bookings in list
	 * @throws ServiceException
	 */
	public static List<BookingDTO> calculateNumberOfBookings() throws ServiceException {
		List<BookingDTO> numberOfBookingsList = null;
			try {
				numberOfBookingsList = BookingDAO.findNumberOfUserBookings();
			} catch (DBException e) {
				e.getMessage();
				throw new ServiceException(e,"can't calculate number of bookings");
				
			}
		return numberOfBookingsList;
	}
	/**
	 * This metho calculates the number of bookings for particular user
	 * @param username
	 * @return
	 * @throws ServiceException
	 */
	public static Integer calculateNumberOfBookingsForUser(String username) throws ServiceException {
		Integer numberOfBookings = null;
			try {
				numberOfBookings = BookingDAO.findNumberOfBookings(username);
			} catch (DBException e) {
				e.getMessage();
				throw new ServiceException(e,"can't calculate number of bookings");
				
			}
		return numberOfBookings;
	}

	
}
