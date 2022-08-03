package com.onlinebookstore.dto;

import java.util.Calendar;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Orders")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer orderId;
	private Calendar orderDate;
	private Calendar deliveryDate;
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
		this.orderDate = Calendar.getInstance();
		// Calendar calender= Calendar.getInstance();
		// calender.add(calender.DAY_OF_MONTH, 7);
		this.deliveryDate = Calendar.getInstance();
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

	public Calendar getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Calendar orderDate) {
		this.orderDate = orderDate;
	}

	public Calendar getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(Calendar deliveryDate) {
		this.deliveryDate = deliveryDate;
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
		return "OrderDetails [orderId=" + orderId + ", orderDate=" + orderDate + ", deliveryDate=" + deliveryDate
				+ ", shippingAddress=" + shippingAddress + ", book=" + book + ", user=" + user + "]";
	}

}
