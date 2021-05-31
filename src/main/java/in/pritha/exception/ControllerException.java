package in.pritha.exception;

public class ControllerException extends Exception {
	private static final long serialVersionUID = 4498707150393905113L;
	
	public ControllerException(String message)
	{
	   super(message);
	}
	
	public ControllerException(Throwable e, String message) {
		super(message,e);
	}
	
	
}


