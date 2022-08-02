package com.onlinebookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


import com.onlinebookstore.dto.Cart;
import com.onlinebookstore.exception.CartException;
import com.onlinebookstore.service.CartService;
@RestController
public class CartController {
	
	@Autowired
	CartService cartService;
	
	@PostMapping("addBook/{cartId}/{bookId}/{qty}")
	public Cart addToCartByBookId(@PathVariable Integer cartId, @PathVariable Integer bookId, @PathVariable Integer qty) throws CartException {
		return this.cartService.addToCartByBookId(cartId, bookId, qty);
	}
	
	@GetMapping("getcart/{cartId}")
	public Cart getCartById(@PathVariable Integer cartId) throws CartException {
		return this.cartService.getCartById(cartId);

	}
	
	@GetMapping("allcarts")
	public List<Cart> getAllCart() throws CartException{
		return this.cartService.getAllCart();
	}
	
	
	
}