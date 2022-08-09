package com.onlinebookstore.dto;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class UserBilling {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@NotNull(message = "Name can not be null")
	@NotEmpty(message = "Name can not be empty")
	@NotBlank(message = "Name is mandetory to fill")
	@Size(min = 3, max = 30, message = "Name must be of minimum 3 characters and maximum of 30 characters")
	private String userBillingName;
	
	@NotNull(message = "Street Address can not be null")
	@NotBlank(message = "Street Address is mandetory to fill")
	@Size(min = 10, max = 50, message = "Street Address must be of minimum 10 characters and maximum of 50 characters")
	private String userBillingStreet1;
	
	private String userBillingStreet2;
	
	@NotNull(message = "City can not be null")
	@NotBlank(message = "City field is mandetory to fill")
	@Size(min = 3, max = 25, message = "City must be of minimum 3 characters and maximum of 25 characters")
	private String userBillingCity;
	
	@NotNull(message = "State can not be null")
	@NotBlank(message = "State field is mandetory to fill")
	@Size(min = 3, max = 30, message = "State must be of minimum 3 characters and maximum of 30 characters")
	private String userBillingState;
	
	@NotNull(message = "Country can not be null")
	@NotBlank(message = "Country field is mandetory to fill")
	@Size(min = 3, max = 30, message = "Country must be of minimum 3 characters and maximum of 30 characters")
	private String userBillingCountry;
	
	@NotNull(message = "Zip code can not be null")
	@NotBlank(message = "Zip code can not be blank")
	@Size(min = 6, max = 6, message = "Zip code must be of 6 digits")
	private String userBillingZipcode;
	
	@OneToOne

	private UserPayment userPayment;

	public UserBilling() {
		super();
	}

	public UserBilling(Long id, String userBillingName, String userBillingStreet1, String userBillingStreet2,
			String userBillingCity, String userBillingState, String userBillingCountry, String userBillingZipcode,
			UserPayment userPayment) {
		super();
		this.id = id;
		this.userBillingName = userBillingName;
		this.userBillingStreet1 = userBillingStreet1;
		this.userBillingStreet2 = userBillingStreet2;
		this.userBillingCity = userBillingCity;
		this.userBillingState = userBillingState;
		this.userBillingCountry = userBillingCountry;
		this.userBillingZipcode = userBillingZipcode;
		this.userPayment = userPayment;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserBillingName() {
		return userBillingName;
	}

	public void setUserBillingName(String userBillingName) {
		this.userBillingName = userBillingName;
	}

	public String getUserBillingStreet1() {
		return userBillingStreet1;
	}

	public void setUserBillingStreet1(String userBillingStreet1) {
		this.userBillingStreet1 = userBillingStreet1;
	}

	public String getUserBillingStreet2() {
		return userBillingStreet2;
	}

	public void setUserBillingStreet2(String userBillingStreet2) {
		this.userBillingStreet2 = userBillingStreet2;
	}

	public String getUserBillingCity() {
		return userBillingCity;
	}

	public void setUserBillingCity(String userBillingCity) {
		this.userBillingCity = userBillingCity;
	}

	public String getUserBillingState() {
		return userBillingState;
	}

	public void setUserBillingState(String userBillingState) {
		this.userBillingState = userBillingState;
	}

	public String getUserBillingCountry() {
		return userBillingCountry;
	}

	public void setUserBillingCountry(String userBillingCountry) {
		this.userBillingCountry = userBillingCountry;
	}

	public String getUserBillingZipcode() {
		return userBillingZipcode;
	}

	public void setUserBillingZipcode(String userBillingZipcode) {
		this.userBillingZipcode = userBillingZipcode;
	}

	public UserPayment getUserPayment() {
		return userPayment;
	}

	public void setUserPayment(UserPayment userPayment) {
		this.userPayment = userPayment;
	}



}
