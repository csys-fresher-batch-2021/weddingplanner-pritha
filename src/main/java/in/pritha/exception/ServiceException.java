package in.pritha.exception;

public class ServiceException extends Exception {
	private static final long serialVersionUID = 1L;
	ServiceException() {
		//default constructor	
		}
		//parametrized consrrucor
		public ServiceException(String exceptionmessage)
		{
		   super(exceptionmessage); //call parent class exception
		}
}
