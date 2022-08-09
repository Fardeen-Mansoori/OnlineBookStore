package com.onlinebookstore.dto;

import java.text.ParseException;

import java.time.LocalDate;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name = "Orders")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer orderId;

	
	private LocalDate orderDate= LocalDate.now();
	
	private LocalDate deliveryDate=LocalDate.now().plusDays(7);
	
	@NotNull(message = "Shipping Address can not be null")
	@NotBlank(message="Shipping Address can not be blank")
	@Size(min=10,max = 50,message = "Shipping Address must be of minimum 10 characters and maximum of 50 characters")
	private String shippingAddress;
	@OneToMany
	private List<Book> book;
	@ManyToOne
	private User user;

	public Order() {
		super();

	}
	public Order(String shippingAddress, List<Book> book, User user) {
		super();
		this.orderDate=LocalDate.now();;
		this.deliveryDate=LocalDate.parse("2022-08-04").plusDays(7);
		//this.deliveryDate = deliveryDate.plusDays(7);
		this.shippingAddress = shippingAddress;
		this.book = book;
		this.user = user;

	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}


	public LocalDate getDeliveryDate() {
		return deliveryDate;
	}



	public String getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public List<Book> getBook() {
		return book;
	}

	public void setBook(List<Book> book) {
		this.book = book;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "OrderDetails [orderId=" + orderId + ", orderDate=" + orderDate + 
				", shippingAddress=" + shippingAddress + ", book=" + book + ", user=" + user + "]";
	}

	
}
