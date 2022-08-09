package com.onlinebookstore.dto;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class User {
	@Id
	private Integer userId;

	//@NotNull(message = "Password can not be null")
	//@NotEmpty(message = "Password can not be empty")
	//@NotBlank(message = "Password can not be blank")
	//@Size(min = 6, max = 25, message = "Password must be of minimum 6 characters and maximum of 25 characters")
	private String userPassword;

	@NotNull(message = "Name can not be null")
	@NotEmpty(message = "Name can not be empty")
	@NotBlank(message = "Name can not be blank")
	@Size(min = 3, max = 30, message = "Name must be of minimum 3 characters and maximum of 30 characters")
	private String userName;

	@Email(message = "Email should be valid")
	private String userEmail;

	@NotBlank(message = "Address field can not be blank")
	@NotNull(message = "Address can not be null")
	private String userAddress;

	@NotBlank(message = "Phone number is mandetory.")
	@Pattern(regexp = "[0-9]{10}", message = "Phone number must be 10 digits[0-9].")
	private String userContact;

	@Temporal(TemporalType.DATE)
	private Date dateOfBirth;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(Integer userId, String userName, String userEmail, String userAddress, String userContact,
			Date dateOfBirth) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userEmail = userEmail;
		this.userAddress = userAddress;
		this.userContact = userContact;
		this.dateOfBirth = dateOfBirth;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public String getUserContact() {
		return userContact;
	}

	public void setUserContact(String userContact) {
		this.userContact = userContact;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	@Override
	public String toString() {
		return "UserDetails [userId=" + userId + ", userName=" + userName + ", userEmail=" + userEmail
				+ ", userAddress=" + userAddress + ", userContact=" + userContact + ", dateOfBirth=" + dateOfBirth
				+ "]";
	}

}
