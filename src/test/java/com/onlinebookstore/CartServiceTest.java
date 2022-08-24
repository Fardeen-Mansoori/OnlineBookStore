package com.onlinebookstore;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.security.PublicKey;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.onlinebookstore.dto.Cart;
import com.onlinebookstore.exception.BookException;
import com.onlinebookstore.exception.CartException;
import com.onlinebookstore.service.CartService;

@SpringBootTest
public class CartServiceTest {
	
	@Autowired
	CartService cartService;
	
	Cart cart= new Cart(null, null);
	
	@Test
	public void  getAllCartTest() throws CartException{
		assertNotNull(this.cartService.addBook(cart));
		assertNotNull(this.cartService.getAllCart());
	}
	@Test
	public void  updateCartTest() throws CartException{
		assertNotNull(this.cartService.addBook(cart));
		assertNotNull(this.cartService.updateCart(cart));
		assertEquals("New Book",this.cartService.updateCart(cart).getBookName());
		assertThrows(BookException.class,()->this.cartService.updateCart(null));
		
	}
	@Test
	public void   clearCartTest() throws CartException{
		assertEquals("Successful", this.cartService.clearCart(cart));
		assertThrows(BookException.class,()-> this.cartService.deleteBookById(0));
	}


}
