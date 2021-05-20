package in.pritha.exception;

public class DBException extends Exception {
	
	private static final long serialVersionUID = -1666188960072778549L;
	DBException() {
		//default constructor	
		}
		//parametrized consrrucor
		public DBException(Throwable e,String message)
		{
		   super(message,e);
		}
}
