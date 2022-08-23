package com.onlinebookstore.service;

import java.util.List;


import com.onlinebookstore.dto.Book;
import com.onlinebookstore.dto.Cart;
import com.onlinebookstore.dto.CartItem;
import com.onlinebookstore.dto.Order;
import com.onlinebookstore.dto.User;




public interface CartItemService {
	
	    List<CartItem> findByCart(Cart cart);

	    CartItem updateCartItem(CartItem cartItem);

	    CartItem addBookToCartItem(Book book, User user, int qty);

	    CartItem findById(Integer id);

	    void removeCartItem(CartItem cartItem);

	    CartItem save(CartItem cartItem);

	    List<CartItem> findByOrder(Order order);

}
