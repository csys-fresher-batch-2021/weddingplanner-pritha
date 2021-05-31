package in.pritha.util;

public class Logger {
	private Logger() {
		// to avoid object creation
	}

	/**
	 * This method will print whatever the arguments passed
	 * 
	 * @param message
	 */
	public static void println(String message) {
		System.out.println(message);
	}

	public static void println(int rows) {
		System.out.println(rows);
		
	}

}
