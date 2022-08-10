package com.onlinebookstore.dto;

import java.util.List;

//import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.springframework.beans.factory.annotation.Autowired;

import com.onlinebookstore.dao.UserRepository;

@Entity
public class Cart {
	//@Autowired
	//UserRepository userRepository;
	
	@Id
	private Integer cartId;
	private Double cartTotal;
	private Integer bookQuantity;
	@OneToOne
	private User user;
	@OneToMany
	private List<Book> book;

	public Cart() {
		super();

		// TODO Auto-generated constructor stub
	}


	public Cart(Integer cartId,User user) {
		super();
		this.cartId = cartId;
		this.user=user;
	}

	public Cart(Integer cartId, Double cartTotal, Integer bookQuantity,User user, List<Book> book) {
		super();
		this.cartId = cartId;
		this.cartTotal = cartTotal;
		this.bookQuantity = bookQuantity;
		this.user = user;
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

	public User getUser() {
		return user;
	}

	public void setUserId(User user) {
		this.user = user;
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
		return "CartDetails [cartId=" + cartId + ", cartTotal=" + cartTotal + ", user=" + user + ", bookId=" + book
				+ ", bookQuantity=" + bookQuantity + "]";
	}

}
