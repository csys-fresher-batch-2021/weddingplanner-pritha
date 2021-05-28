package in.pritha.validator;

import java.time.LocalDate;
import java.time.LocalTime;

import in.pritha.exception.MyException;

public class BookingDateTimeValidator {
	
	private BookingDateTimeValidator() {
		
	}
	/**
	 * This method checks the date and time by the user
	 * @param wedDate
	 * @param wedTime
	 * @return true if the booking date and time is after the current date and time
	 */
	public static boolean dateTimeValidator(LocalDate wedDate, LocalTime wedTime, String wedLocation) {
		boolean valid = false;
		LocalDate currentdate = LocalDate.now(); // current date //
		LocalTime time1 = LocalTime.parse("04:00:00"); //from 4 am to 4 pm should be the wedding time//
		LocalTime time2 = LocalTime.parse("16:00:00");
		if ((wedDate.isBefore(currentdate)) || (wedTime.isBefore(time1) || wedTime.isAfter(time2))
				|| (wedDate.isEqual(currentdate))) {
			
			throw new MyException("Your Entered Date/time is incorrect");
		}
		else {
			valid=true;
		}
		
		if(!(StringValidator.isValidString(wedLocation))) {
			
			throw new MyException("Your Location is incorrect");
		}

		return valid;

	}


}
