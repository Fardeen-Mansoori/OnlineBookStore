package com.onlinebookstore.dto;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
	@Id
	private Integer userId;
	private String userPassword;
	private String userName;
	private String userEmail;
	private String userAddress;
	private Integer userContact;
	private Date dateOfBirth;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(Integer userId, String userName, String userEmail, String userAddress, Integer userContact,
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

	public Integer getUserContact() {
		return userContact;
	}

	public void setUserContact(Integer userContact) {
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
