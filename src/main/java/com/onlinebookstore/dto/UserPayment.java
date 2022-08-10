package com.onlinebookstore.dto;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
public class UserPayment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotNull(message = "Payment type can not be null")
	@NotBlank(message="Payment type can not be blank")
	@Size(min=3,max = 25,message = "payment type must be of minimum 3 characters and maximum of 25 characters")
	private String type;
	
	@NotNull(message = "CardName can not be null")
	@NotBlank(message="CardName can not be blank")
	@Size(min=3,max = 30,message = "CardName must be of minimum 3 characters and maximum of 30 characters")
	private String cardName;
	
	@NotNull(message = "CardNumber can not be null")
	@NotBlank(message="CardNumber can not be blank")
	@Size(min=16,max =16,message = "CardNumber must be of 16 digits")
	private String cardNumber;
	
	@NotNull(message="Expiry month cannot be null")
	@Min(1)
	@Max(12)
	private int expiryMonth;
	
	@NotNull
	private int expiryYear;

	@NotNull(message = "cvc cannot be null")
	@Digits(message="cvc must contain 3 digits.", fraction = 0, integer = 3)
	private int cvc;
	
	@NotNull(message = "Holder name can not be null")
	@NotBlank(message="Holder name can not be blank")
	@Size(min=3,max = 30,message = "Holder name must be of minimum 3 characters and maximum of 30 characters")
	private String holderName;
	
	private boolean defaultPayment;
	@ManyToOne
	private User user;

	@OneToOne
	
	private UserBilling userBilling;


	public UserPayment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserPayment(Long id, String type, String cardName, String cardNumber, int expiryMonth, int expiryYear,
			int cvc, String holderName, boolean defaultPayment, User user, UserBilling userBilling) {
		super();
		this.id = id;
		this.type = type;
		this.cardName = cardName;
		this.cardNumber = cardNumber;
		this.expiryMonth = expiryMonth;
		this.expiryYear = expiryYear;
		this.cvc = cvc;
		this.holderName = holderName;
		this.defaultPayment = defaultPayment;
		this.user = user;
		this.userBilling = userBilling;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCardName() {
		return cardName;
	}

	public void setCardName(String cardName) {
		this.cardName = cardName;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public int getExpiryMonth() {
		return expiryMonth;
	}

	public void setExpiryMonth(int expiryMonth) {
		this.expiryMonth = expiryMonth;
	}

	public int getExpiryYear() {
		return expiryYear;
	}

	public void setExpiryYear(int expiryYear) {
		this.expiryYear = expiryYear;
	}

	public int getCvc() {
		return cvc;
	}

	public void setCvc(int cvc) {
		this.cvc = cvc;
	}

	public String getHolderName() {
		return holderName;
	}

	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}

	public boolean isDefaultPayment() {
		return defaultPayment;
	}

	public void setDefaultPayment(boolean defaultPayment) {
		this.defaultPayment = defaultPayment;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public UserBilling getUserBilling() {
		return userBilling;
	}

	public void setUserBilling(UserBilling userBilling) {
		this.userBilling = userBilling;
	}
	
	
}
