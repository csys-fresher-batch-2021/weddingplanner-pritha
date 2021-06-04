package in.pritha.dto;

public class BookingDTO {
	
	
	
	private String username;
	public BookingDTO(String username, Integer noOfBookings) {
		super();
		this.username = username;
		this.noOfBookings = noOfBookings;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Integer getNoOfBookings() {
		return noOfBookings;
	}
	public void setNoOfBookings(Integer noOfBookings) {
		this.noOfBookings = noOfBookings;
	}

	private Integer noOfBookings;

}
