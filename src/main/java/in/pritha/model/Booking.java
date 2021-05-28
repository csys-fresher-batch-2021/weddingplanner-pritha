package in.pritha.model;

import java.time.LocalDate;
import java.time.LocalTime;


public class Booking {
	
	public Booking(String userName, String weddingStyle) {
		super();
		this.userName = userName;
		this.weddingStyle = weddingStyle;
	}
	
	private Integer booking_id;
	private String cancellationReason;
	public String getCancellationReason() {
		return cancellationReason;
	}
	public void setCancellationReason(String cancellationReason) {
		this.cancellationReason = cancellationReason;
	}
	public Booking(Integer booking_id, String cancellationReason, String status, String userName, LocalDate weddingDate,
			LocalTime weddingTime, String weddingLocation, String weddingStyle, String weddingStyleLocation,
			String weddingFoodType, String weddingGuestCount, String weddingDecorType) {
		super();
		this.booking_id = booking_id;
		this.cancellationReason = cancellationReason;
		this.status = status;
		this.userName = userName;
		this.weddingDate = weddingDate;
		this.weddingTime = weddingTime;
		this.weddingLocation = weddingLocation;
		this.weddingStyle = weddingStyle;
		this.weddingStyleLocation = weddingStyleLocation;
		this.weddingFoodType = weddingFoodType;
		this.weddingGuestCount = weddingGuestCount;
		this.weddingDecorType = weddingDecorType;
	}

	private String status;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Integer getBooking_id() {
		return booking_id;
	}
	public void setBooking_id(Integer booking_id) {
		this.booking_id = booking_id;
	}
	public Booking(Integer booking_id,String status, String userName, LocalDate weddingDate, LocalTime weddingTime,
			String weddingLocation, String weddingStyle, String weddingStyleLocation, String weddingFoodType,
			String weddingGuestCount, String weddingDecorType) {
		super();
		this.booking_id = booking_id;
		this.status = status;
		this.userName = userName;
		this.weddingDate = weddingDate;
		this.weddingTime = weddingTime;
		this.weddingLocation = weddingLocation;
		this.weddingStyle = weddingStyle;
		this.weddingStyleLocation = weddingStyleLocation;
		this.weddingFoodType = weddingFoodType;
		this.weddingGuestCount = weddingGuestCount;
		this.weddingDecorType = weddingDecorType;
	}

	private String userName;
	private LocalDate weddingDate;
	private LocalTime weddingTime;
	private String weddingLocation;
	private String weddingStyle;
	private String weddingStyleLocation;
	private String weddingFoodType;
	private String weddingGuestCount;
	private String weddingDecorType;
	public  String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public LocalDate getWeddingDate() {
		return weddingDate;
	}
	public void setWeddingDate(LocalDate weddingDate) {
		this.weddingDate = weddingDate;
	}
	public LocalTime getWeddingTime() {
		return weddingTime;
	}
	public void setWeddingTime(LocalTime weddingTime) {
		this.weddingTime = weddingTime;
	}
	public String getWeddingLocation() {
		return weddingLocation;
	}
	public void setWeddingLocation(String weddingLocation) {
		this.weddingLocation = weddingLocation;
	}
	public String getWeddingStyle() {
		return weddingStyle;
	}
	public void setWeddingStyle(String weddingStyle) {
		this.weddingStyle = weddingStyle;
	}
	public String getWeddingStyleLocation() {
		return weddingStyleLocation;
	}
	public void setWeddingStyleLocation(String weddingStyleLocation) {
		this.weddingStyleLocation = weddingStyleLocation;
	}
	public String getWeddingFoodType() {
		return weddingFoodType;
	}
	public void setWeddingFoodType(String weddingFoodType) {
		this.weddingFoodType = weddingFoodType;
	}
	public String getWeddingGuestCount() {
		return weddingGuestCount;
	}
	public void setWeddingGuestCount(String weddingGuestCount) {
		this.weddingGuestCount = weddingGuestCount;
	}
	public Booking(String userName, String weddingStyle, String weddingStyleLocation) {
		super();
		this.userName = userName;
		this.weddingStyle = weddingStyle;
		this.weddingStyleLocation = weddingStyleLocation;
	}
	public String getWeddingDecorType() {
		return weddingDecorType;
	}
	public void setWeddingDecorType(String weddingDecorType) {
		this.weddingDecorType = weddingDecorType;
	}
	
	public Booking(String userName, LocalDate weddingDate, LocalTime weddingTime, String weddingLocation,
			String weddingStyle, String weddingStyleLocation, String weddingFoodType, String weddingGuestCount,
			String weddingDecorType) {
		super();
		this.userName = userName;
		this.weddingDate = weddingDate;
		this.weddingTime = weddingTime;
		this.weddingLocation = weddingLocation;
		this.weddingStyle = weddingStyle;
		this.weddingStyleLocation = weddingStyleLocation;
		this.weddingFoodType = weddingFoodType;
		this.weddingGuestCount = weddingGuestCount;
		this.weddingDecorType = weddingDecorType;
		
		
	}
	public Booking(String userName, LocalDate weddingDate, LocalTime weddingTime, String weddingLocation) {
		super();
		this.userName = userName;
		this.weddingDate = weddingDate;
		this.weddingTime = weddingTime;
		this.weddingLocation = weddingLocation;
	}
	public Booking() {
		super();
	}
	
	
	

	
	
	
	
	

}
