package in.pritha.model;

import java.time.LocalDate;

public class Payment {

	// payment domain class

	
	private String cardType;
	private String cardUserName;
	public String getCardUserName() {
		return cardUserName;
	}

	public void setCardUserName(String cardUserName) {
		this.cardUserName = cardUserName;
	}

	private Integer bookingId;
	private Long cardNo;
	private LocalDate expiryDate;
	private Integer cvv;
	private Integer amount;
	private String purpose;
	private String status;
	private String transactionCode;
	private String discountCode;

	

	public String getDiscountCode() {
		return discountCode;
	}

	public void setDiscountCode(String discountCode) {
		this.discountCode = discountCode;
	}

	public Payment(String userName, Integer bookingId, String cardType, Integer amount, String status,
			String transactionCode) {
		super();
		this.cardType = cardType;
		this.cardUserName = userName;
		this.bookingId = bookingId;
		this.amount = amount;
		this.status = status;
		this.transactionCode = transactionCode;
	}

	public Payment() {
		
	}

	

	public Payment(String cardType, String cardUserName, Long cardNo, LocalDate expiryDate, Integer cvv,
			Integer amount, String purpose, String discountCode) {
		super();
		this.cardType=cardType;
		this.cardUserName =cardUserName;
		this.cardNo = cardNo;
		this.expiryDate = expiryDate;
		this.cvv = cvv;
		this.amount=amount;
		this.purpose = purpose;
		this.discountCode=discountCode;
		
		
	
	
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTransactionCode() {
		return transactionCode;
	}

	public void setTransactionCode(String transactionCode) {
		this.transactionCode = transactionCode;
	}

	/**
	 * Encaspulation is done and using set and get methods, retrieved the hiding
	 * data
	 * @return cardNo
	 */
	
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	

	public LocalDate getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(LocalDate expiryDate) {
		this.expiryDate = expiryDate;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardNo(Long cardNo) {
		this.cardNo = cardNo;
	}

	
	public long getCardNo() {
		return cardNo;
	}
	@Override
	public String toString() {
		return "Payment [cardType=" + cardType + ", userName=" + cardUserName + ", cardNo=" + cardNo + ", expiryDate="
				+ expiryDate + ", cvv=" + cvv + ", amount=" + amount + ", purpose=" + purpose + "]";
	}

	/**
	 * Encaspulation is done and using set and get methods, retrieved the hiding
	 * data
	 * @return cvv
	 */
	public void setCvv(Integer cvv) {
		this.cvv = cvv;
	}

	public Integer getCvv() {
		return cvv;
	}
	public Integer getBookingId() {
		return bookingId;
	}

	public void setBookingId(Integer bookingId) {
		this.bookingId = bookingId;
	}

	public void setUserName(String cardUserName) {
		this.cardUserName= cardUserName;
		
	}

}
