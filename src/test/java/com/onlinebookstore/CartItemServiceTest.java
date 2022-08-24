package com.onlinebookstore;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.List;

import com.onlinebookstore.dto.Book;
import com.onlinebookstore.dto.Cart;
import com.onlinebookstore.dto.CartItem;
import com.onlinebookstore.dto.User;
import com.onlinebookstore.exception.BookException;
import com.onlinebookstore.exception.CartException;
import com.onlinebookstore.exception.UserException;
import com.onlinebookstore.service.BookService;
import com.onlinebookstore.service.CartItemService;
import com.onlinebookstore.service.CartItemServiceImpl;
import com.onlinebookstore.service.CartService;
import com.onlinebookstore.service.CartServiceImpl;
import com.onlinebookstore.service.UserService;

@SpringBootTest
public class CartItemServiceTest {

	@Autowired
	CartItemService cartItemService;

	@Autowired
	CartService cartService;

	@Autowired
	BookService bookService;

	@Autowired
	UserService userService;

	CartItem cartItem;
	CartItem newCartItem;
	List<CartItem> cartItemList;

	Cart newCart;

	Book newBook;
	User newUser;

	@BeforeEach
	public void DataCreation() throws CartException, UserException, BookException {
		List<Cart> cartList = this.cartService.getAllCart();
		for(Cart cart : cartList) {
			if(cart.getCartId()==322) {
				newCart = cart;
			}
		}
		cartItemList = this.cartItemService.findByCart(newCart);
		cartItem = cartItemList.get(0);
		newCartItem = cartItemList.get(1);
        newBook = bookService.getBookById(0);
        newUser = userService.getUserById(321);
	}

	@Test
	public void findByCart() {
		assertNotNull(this.cartItemService.findByCart(newCart));
	}

	@Test
	public void updateCartItemTest() {

		assertNotNull(this.cartItemService.updateCartItem(cartItem));

	}

	@Test
	public void addBookToCartItemTest() {
		assertNotNull(this.cartItemService.addBookToCartItem(newBook,newUser,10));

	}

	@Test
	public void findByIdTest() {
		
		assertNotNull(this.cartItemService.findById(cartItem.getId()));
		
	}

	@Test
	public void removeCartItemTest() {

		
		CartItemServiceImpl myList = mock(CartItemServiceImpl.class);
	    doNothing().when(myList).removeCartItem(newCartItem);
	    myList.removeCartItem(newCartItem);
	 
	    verify(myList, times(1)).removeCartItem(newCartItem);
	}

	@Test
	public void saveTest() {
		CartItem cartItem1 = new CartItem();
		assertNotNull(this.cartItemService.save(cartItem1));

	}
}
