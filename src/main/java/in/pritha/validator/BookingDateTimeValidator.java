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
		LocalTime currenttime = LocalTime.now();// current time //

		if ((wedDate.isBefore(currentdate)) || (wedTime.isBefore(currenttime))
				|| (wedDate.isEqual(currentdate))) {
			
			throw new MyException("Your Entered Date/time is incorrect");
		}
		if(!(StringValidator.isValidString(wedLocation))) {
			
			throw new MyException("Your Location is incorrect");
		}

		if (wedDate.isAfter(currentdate) && wedTime.isAfter(currenttime)) {
			valid = true;
		}

		return valid;

	}


}
