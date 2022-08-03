package com.onlinebookstore.service;

import java.util.List;

import com.onlinebookstore.dto.Cart;
import com.onlinebookstore.exception.BookException;
import com.onlinebookstore.exception.CartException;

public interface CartService {
	
	Cart addToCartByBookId(Integer cartId, Integer bookId, Integer qty) throws CartException, BookException;
	Cart getCartById(Integer cartId) throws CartException;
	Cart removeBookFromCart(Integer cartId, Integer bookId,Integer qty) throws CartException;
	List<Cart> getAllCart() throws CartException;
	Cart updateCartItem(Cart cart) throws CartException;
	
}
