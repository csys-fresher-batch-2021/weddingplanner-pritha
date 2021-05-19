package in.pritha.exception;

public class DBException extends Exception {
	
	private static final long serialVersionUID = 4498707150393905113L;
	
		public DBException(String message)
		{
		   super(message);
		}
		
		public DBException(Throwable e, String message) {
			super(message,e);
		}
}
