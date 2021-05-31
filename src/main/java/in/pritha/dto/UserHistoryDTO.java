package in.pritha.dto;

import java.sql.Date;
import java.time.LocalDate;

public class UserHistoryDTO {
	
	private String userName;
	   public UserHistoryDTO(String userName, Integer bookingId, Integer amount,
			Date bookingDate, Date paymentDate) {
		super();
		this.userName = userName;
		this.bookingId = bookingId;
		
		this.amount = amount;
		this.bookingDate = bookingDate;
		this.paymentDate = paymentDate;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Integer getBookingId() {
		return bookingId;
	}
	public void setBookingId(Integer bookingId) {
		this.bookingId = bookingId;
	}
	
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public Date getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}
	public Date getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}
	private Integer bookingId;
	   private Integer amount;
	   private Date bookingDate;
	   private Date paymentDate;
	  // private SubjectDTO subject;

}
