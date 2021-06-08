package in.pritha.model;

public class Discount {
	private String username;
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	private Integer bookingId;
	private Integer numberOfBookings;
	private String discountStatus;
	public Discount() {
		
	}
	public Discount(Integer bookingId, Integer numberOfBookings,  String discountStatus) {
		super();
		this.bookingId = bookingId;
		this.numberOfBookings = numberOfBookings;
		this.discountStatus = discountStatus;
	}
	public Integer getBookingId() {
		return bookingId;
	}
	public String getDiscountStatus() {
		return discountStatus;
	}
	public Integer getNumberOfBookings() {
		return numberOfBookings;
	}
	
	public void setBookingId(Integer bookingId) {
		this.bookingId = bookingId;
	}
	public void setDiscountStatus(String discountStatus) {
		this.discountStatus = discountStatus;
	}
	public void setNumberOfBookings(Integer numberOfBookings) {
		this.numberOfBookings = numberOfBookings;
	}
	

}
