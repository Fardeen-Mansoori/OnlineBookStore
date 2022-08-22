package com.onlinebookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlinebookstore.dto.Book;
import com.onlinebookstore.dto.Cart;
import com.onlinebookstore.dto.CartItem;
import com.onlinebookstore.dto.User;
import com.onlinebookstore.exception.BookException;
import com.onlinebookstore.exception.CartException;
import com.onlinebookstore.exception.UserException;
import com.onlinebookstore.service.BookService;
import com.onlinebookstore.service.CartItemService;
import com.onlinebookstore.service.CartService;
import com.onlinebookstore.service.UserService;

@RestController
public class CartController {

	@Autowired
	private CartService cartService;

	@Autowired
	private UserService userService;

	@Autowired
	private CartItemService cartItemService;

	@Autowired
	private BookService bookService;

//	

	@GetMapping("cart/{userId}")
	public Cart getCartByUserId(@PathVariable Integer userId) throws CartException, UserException {
		User user = this.userService.getUserById(userId);
		Cart cart = user.getCart();

		return cart;

	}

	@PostMapping("addBook/{userId}/{bookId}/{qty}")
	public String addBookToCart(@PathVariable Integer userId, @PathVariable Integer bookId, @PathVariable int qty)
			throws BookException, UserException, CartException {
		User user = userService.getUserById(userId);
		Book book = bookService.getBookById(bookId);
		CartItem cartItem = this.cartItemService.addBookToCartItem(book, user, qty);
		cartService.updateCart(cartItem.getCart());
		return "Book Added Successfully";
	}

	@PutMapping("updateCart/{cartItemId}/{qty}")
	public String updateCart(@PathVariable Integer cartItemId, @PathVariable int qty) throws CartException {
		CartItem cartItem = cartItemService.findById(cartItemId);
		cartItem.setQty(qty);
		cartItemService.updateCartItem(cartItem);
		cartService.updateCart(cartItemService.findById(cartItemId).getCart());
		return "Cart Updated Successfully";
	}

	@PutMapping("clearCart/{userId}")
	public String clearCart(@PathVariable Integer userId) throws UserException, CartException {
		User user = userService.getUserById(userId);
		Cart cart = user.getCart();
		cartService.clearCart(cart);
		return "Cart cleared Successfully";
	}

	@DeleteMapping("removeBook/{userId}/{cartItemId}")
	public String removeBookFromCart(@PathVariable Integer userId, @PathVariable Integer cartItemId)
			throws CartException, UserException {

		User user = this.userService.getUserById(userId);
		cartItemService.removeCartItem(cartItemService.findById(cartItemId));
		cartService.updateCart(user.getCart());
		return "Book Removed Successfully";
	}

	@GetMapping("carts")
	public List<Cart> getAllCart() throws CartException {
		return this.cartService.getAllCart();
	}

}
