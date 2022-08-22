package com.onlinebookstore.dto;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
public class User {
	@Id
	private Integer userId;
	

    @JsonProperty(access = Access.WRITE_ONLY)
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

	@OneToOne(cascade = CascadeType.ALL, mappedBy = "user")
	@JsonIgnore
	
	private Wishlist wishlist;

	@OneToMany(mappedBy = "user")
	@JsonIgnore
	
	private List<Order> orderList;

	@OneToOne(cascade = CascadeType.ALL, mappedBy = "user")
	@JsonIgnore
	
	private Cart cart;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(Integer userId, String userPassword, String userName, String userEmail, String userAddress,
			String userContact, Date dateOfBirth, Wishlist wishlist, List<Order> orderList, Cart cart) {
		super();
		this.userId = userId;
		this.userPassword = userPassword;
		this.userName = userName;
		this.userEmail = userEmail;
		this.userAddress = userAddress;
		this.userContact = userContact;
		this.dateOfBirth = dateOfBirth;
		this.wishlist = wishlist;
		this.orderList = orderList;
		this.cart = cart;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
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

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public Wishlist getWishlist() {
		return wishlist;
	}

	public void setWishlist(Wishlist wishlist) {
		this.wishlist = wishlist;
	}

	public List<Order> getOrderList() {
		return orderList;
	}

	public void setOrderList(List<Order> orderList) {
		this.orderList = orderList;
	}

	@Override
	public String toString() {
		return "UserDetails [userId=" + userId + ", userName=" + userName + ", userEmail=" + userEmail
				+ ", userAddress=" + userAddress + ", userContact=" + userContact + ", dateOfBirth=" + dateOfBirth
				+ "]";
	}

}
