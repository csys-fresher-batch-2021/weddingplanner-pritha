package in.pritha.exception;

public class ValidationException extends Exception{
	private static final long serialVersionUID = 1L;
	ValidationException() {
		//default constructor	
		}
		//parametrized consrrucor
		public ValidationException(String exceptionMessage)
		{
		   super(exceptionMessage); //call parent class exception
		}
		
		public ValidationException(Throwable e, String message) {
			super(message,e);
		}

}
