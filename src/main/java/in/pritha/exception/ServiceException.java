package in.pritha.exception;

public class ServiceException extends Exception {
	private static final long serialVersionUID = -921890843278011885L;
	
	 ServiceException() {
			//default constructor	
			}
			//parametrized consrrucor
			public ServiceException(String message)
			{
			   super(message);
			}
}
