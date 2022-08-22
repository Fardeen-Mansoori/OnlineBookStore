package com.onlinebookstore.service;

import java.util.List;

import com.onlinebookstore.dto.Cart;

import com.onlinebookstore.exception.CartException;

public interface CartService {

	List<Cart> getAllCart() throws CartException;

	Cart updateCart(Cart cart) throws CartException;

	void clearCart(Cart cart) throws CartException;

}
