package com.onlinebookstore.service;

import java.util.List;



import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinebookstore.dao.BookToCartItemRepository;
import com.onlinebookstore.dao.CartItemRepository;
import com.onlinebookstore.dto.Book;
import com.onlinebookstore.dto.BookToCartItem;
import com.onlinebookstore.dto.Cart;
import com.onlinebookstore.dto.CartItem;
import com.onlinebookstore.dto.Order;
import com.onlinebookstore.dto.User;


@Service
public class CartItemServiceImpl implements CartItemService {

	@Autowired
	private CartItemRepository cartItemRepository;

	@Autowired
	private BookToCartItemRepository bookToCartItemRepository;
	
	@Override
	public List<CartItem> findByCart(Cart cart) {
		// TODO Auto-generated method stub
		return this.cartItemRepository.findByCart(cart);
	}

	@Override
	public CartItem updateCartItem(CartItem cartItem) {
		// TODO Auto-generated method stub
		cartItem.setSubtotal(cartItem.getBook().getBookPrice() * cartItem.getQty());
		this.cartItemRepository.save(cartItem);

		return cartItem;
	}

	@Override
	public CartItem addBookToCartItem(Book book, User user, int qty)  {
		// TODO Auto-generated method stub
		List<CartItem> cartItemList = findByCart(user.getCart());

		for (CartItem cartItem : cartItemList) {
			if (book.getBookId() == cartItem.getBook().getBookId()) {
				cartItem.setQty(cartItem.getQty() + qty);
				cartItem.setSubtotal(book.getBookPrice() * cartItem.getQty());
				cartItemRepository.save(cartItem);
				//cartService.updateCart(user.getCart());
				return cartItem;
			}
		}

		CartItem cartItem = new CartItem();
		cartItem.setCart(user.getCart());
		cartItem.setBook(book);

		cartItem.setQty(qty);
		cartItem.setSubtotal(book.getBookPrice() * cartItem.getQty());
		cartItem = cartItemRepository.save(cartItem);

		BookToCartItem bookToCartItem = new BookToCartItem();
		bookToCartItem.setBook(book);
		bookToCartItem.setCartItem(cartItem);
		bookToCartItemRepository.save(bookToCartItem);
		//cartService.updateCart(user.getCart());
		return cartItem;
	}
 
	@Override
	public CartItem findById(Integer id) {
		// TODO Auto-generated method stub
		return cartItemRepository.findById(id).get();
	}

	@Override
	@Transactional
	public void removeCartItem(CartItem cartItem) {
		// TODO Auto-generated method stub
		bookToCartItemRepository.deleteByCartItem(cartItem);
		cartItemRepository.delete(cartItem);

	}

	@Override
	public CartItem save(CartItem cartItem) {
		// TODO Auto-generated method stub
		return cartItemRepository.save(cartItem);
	}

	@Override
	public List<CartItem> findByOrder(Order order) {
		// TODO Auto-generated method stub
		return cartItemRepository.findByOrder(order);

	}

}
