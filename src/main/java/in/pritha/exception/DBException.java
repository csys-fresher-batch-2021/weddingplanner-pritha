package in.pritha.exception;

public class DBException extends Exception {
	
	private static final long serialVersionUID = 4498707150393905113L;
	DBException() {
		//default constructor	
		}
		//parametrized consrrucor
		public DBException(String str)
		{
		   super(str);
		}
}
