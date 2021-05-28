package in.pritha.model;

import java.time.LocalDate;

public class Payment {

	// payment domain class

	
	private String cardType;
	private String userName;
	private Long cardNo;
	private LocalDate expiryDate;
	private Integer cvv;
	private Integer amount;
	private String purpose;

	

	/**
	 * Encaspulation is done and using set and get methods, retrieved the hiding
	 * data
	 * @return cardNo
	 */
	
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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
		return "Payment [cardType=" + cardType + ", userName=" + userName + ", cardNo=" + cardNo + ", expiryDate="
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

}
