package in.pritha.exception;

public class MyException extends RuntimeException {
	
	
	private static final long serialVersionUID = 1L;

	 MyException() {
	//default constructor	
	}
	//parametrized consrrucor
	public MyException(String str)
	{
	   super(str);
	}

}
