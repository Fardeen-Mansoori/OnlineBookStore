package com.onlinebookstore.service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinebookstore.dao.CartRepository;
import com.onlinebookstore.dto.Book;
import com.onlinebookstore.dto.Cart;
import com.onlinebookstore.exception.BookException;
import com.onlinebookstore.exception.CartException;

@Service
public class CartServiceImpl implements CartService {
	@Autowired
	CartRepository cartRepository;
	// @Autowired
	// BookRepository bookRepository;
	@Autowired
	BookService bookService;

	@Override
	public Cart addToCartByBookId(Integer cartId, Integer bookId, Integer qty) throws CartException, BookException {
		Double subTotal;
		Optional<Cart> foundCart = this.cartRepository.findById(cartId);
		if (!foundCart.isPresent()) {
			throw new CartException("Cart not found!");
		}
		List<Book> newBookIdList = foundCart.get().getBook();

		Book foundBook = bookService.getBookById(bookId);
		

		for (Integer i = 0; i < qty; i++) {
			newBookIdList.add(foundBook);
		}

		foundCart.get().setBookQuantity(newBookIdList.size());
		subTotal = foundBook.getBookPrice() * qty;
		if (foundCart.get().getCartTotal() != null) {
			foundCart.get().setCartTotal(foundCart.get().getCartTotal() + subTotal);
		} else {
			foundCart.get().setCartTotal(subTotal);
		}
		this.cartRepository.save(foundCart.get());

		return foundCart.get();
	}
	
	@Override
	public Cart getCartById(Integer cartId) throws CartException {

		Optional<Cart> optCart = cartRepository.findById(cartId);

		if (optCart.isEmpty()) {
			throw new CartException("Cart doesn't exist for cartid " + cartId);
		}

		return optCart.get();

	}

	@Override
	public Cart removeBookFromCart(Integer cartId, Integer bookId, Integer qty) throws CartException {
		return null;

	}

	@Override
	public List<Cart> getAllCart() throws CartException {
		return this.cartRepository.findAll();
	}

	@Override
	public Cart updateCartItem(Cart cart) throws CartException {
		return null;
	}

}
