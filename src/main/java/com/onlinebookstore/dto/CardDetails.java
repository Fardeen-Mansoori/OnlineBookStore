package com.onlinebookstore.dto;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class CardDetails {

	private String cardHolderName;
	@Id
	private Integer cardNumber;
	private Date expiryDate;
	private Integer cardCvv;
	public CardDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CardDetails(String cardHolderName, Integer cardNumber, Date expiryDate, Integer cardCvv) {
		super();
		this.cardHolderName = cardHolderName;
		this.cardNumber = cardNumber;
		this.expiryDate = expiryDate;
		this.cardCvv = cardCvv;
	}
	public String getCardHolderName() {
		return cardHolderName;
	}
	public void setCardHolderName(String cardHolderName) {
		this.cardHolderName = cardHolderName;
	}
	public Integer getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(Integer cardNumber) {
		this.cardNumber = cardNumber;
	}
	@Override
	public String toString() {
		return "CardDetails [cardHolderName=" + cardHolderName + ", cardNumber=" + cardNumber + "]";
	}
	
}
