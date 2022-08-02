package com.onlinebookstore.dto;

import java.util.List;

//import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Cart {
	@Id
	private Integer cartId;
	private Double cartTotal;
	private Integer bookQuantity;
	@OneToOne
	private User userId;
	@OneToMany
	private List<Book> book;
	public Cart() {
		super();
		
		// TODO Auto-generated constructor stub
	}
	
	public Cart(Integer cartId) {
		super();
		this.cartId = cartId;
	}

	
	public Cart(Integer cartId, Double cartTotal, Integer bookQuantity, User userId, List<Book> book) {
		super();
		this.cartId = cartId;
		this.cartTotal = cartTotal;
		this.bookQuantity = bookQuantity;
		this.userId = userId;
		this.book = book;
	}

	public Integer getCartId() {
		return cartId;
	}
	public void setCartId(Integer cartId) {
		this.cartId = cartId;
	}
	public Double getCartTotal() {
		return cartTotal;
	}
	public void setCartTotal(Double cartTotal) {
		this.cartTotal = cartTotal;
	}
	public User getUserId() {
		return userId;
	}
	public void setUserId(User userId) {
		this.userId = userId;
	}
	public List<Book> getBook() {
		return book;
	}
	public void setBookId(List<Book> book) {
		this.book = book;
	}
	public Integer getBookQuantity() {
		return bookQuantity;
	}
	public void setBookQuantity(Integer bookQuantity) {
		this.bookQuantity = bookQuantity;
	}
	@Override
	public String toString() {
		return "CartDetails [cartId=" + cartId + ", cartTotal=" + cartTotal + ", userId=" + userId + ", bookId="
				+ book + ", bookQuantity=" + bookQuantity + "]";
	}
	
	
	
	
}
