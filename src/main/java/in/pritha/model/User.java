package in.pritha.model;

public class User {
	
	private String userName;
	private String passWord;
	private Long mobileNo;
	private String createPassword;
	private String confirmPassword;
	
	/**
	 * This method return the userName
	 * @return
	 */
	public String getuserName() {
		return userName;
	}
	
	/**
	 * This method return the passWord                               
	 * @return
	 */
	public String getpassWord() {
		return passWord;
	}
	/**
	 * This method return the mobileNo                               
	 * @return
	 */
	public Long getMobileNo() {
		return mobileNo;
	}
	/**
	 * This method return createpassword
	 */
	public String getCreatePassword() {
		return createPassword;
	}
	/**
	 * This method return confirmpassword
	 */
	public String getConfirmPassword() {
		return confirmPassword;
	}
	/**
	 * Private constructor to initialize fields
	 * @param createPassword
	 * @param confirmPassword
	 * @param userName
	 */
	public User(String createPassword, String confirmPassword, String userName){
		this.createPassword = createPassword;
		this.confirmPassword = confirmPassword;
		this.userName = userName;
	}
	
	/**
	 * Private constrcutor used to initiiaize fields
	 * @param userName
	 * @param passWord
	 * @param mobileNo
	 */
	public User(String userName, String passWord, Long mobileNo) {
		super();
		this.userName = userName;
		this.passWord = passWord;
		this.mobileNo = mobileNo;
	}

	/**
	 * Private constructor to avoid object creation 
	 * @param username
	 * @param passWord
	 */
	public User(String userName, String passWord) {
		super();
		this.userName = userName;
		this.passWord = passWord;
	}
	/**
	 * to string method
	 */
	@Override
	public String toString() {
		return "User [userName=" + userName + ", passWord=" + passWord + ", createPassword=" + createPassword
				+ ", confirmPassword=" + confirmPassword + "]";
	}
	
	

}
