package com.onlinebookstore.dto;

import java.util.List;


import javax.persistence.CascadeType;

//import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@Entity
public class Cart {
	//@Autowired
	//UserRepository userRepository;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer cartId;
	private Double cartTotal;
	//private Integer bookQuantity;
	
	@OneToMany(mappedBy="cart", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	//@JsonIgnore
	private List<CartItem> cartItemList;
	
	@OneToOne(cascade = CascadeType.ALL)
	private User user;
	
	

	public Cart() {
		super();

		// TODO Auto-generated constructor stub
	}


	public Cart(Integer cartId,User user) {
		super();
		this.cartId = cartId;
		this.user=user;
	}

	

	public Cart(Integer cartId, Double cartTotal, List<CartItem> cartItemList, User user) {
		super();
		this.cartId = cartId;
		this.cartTotal = cartTotal;
		//this.bookQuantity = bookQuantity;
		this.cartItemList = cartItemList;
		this.user = user;
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

	
	
	public List<CartItem> getCartItemList() {
		return cartItemList;
	}


	public void setCartItemList(List<CartItem> cartItemList) {
		this.cartItemList = cartItemList;
	}


	public void setUser(User user) {
		this.user = user;
	}


	

	

	
}
