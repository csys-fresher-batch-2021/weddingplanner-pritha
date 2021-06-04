package in.pritha.dto;

import java.time.LocalDateTime;

public class UserHistoryDTO {
	
	
	private String username;
	public UserHistoryDTO(String username, Integer bookingId, Integer amount, LocalDateTime bookingDate,
			LocalDateTime paymentDate) {
		super();
		this.username = username;
		this.bookingId = bookingId;
		this.amount = amount;
		this.bookingDate = bookingDate;
		this.paymentDate = paymentDate;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	private Integer bookingId;
	   private Integer amount;
	   private LocalDateTime bookingDate;
	   private LocalDateTime paymentDate;
	  // private SubjectDTO subject;
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
	public LocalDateTime getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(LocalDateTime bookingDate) {
		this.bookingDate = bookingDate;
	}
	public LocalDateTime getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(LocalDateTime paymentDate) {
		this.paymentDate = paymentDate;
	}

}
