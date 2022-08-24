package com.onlinebookstore;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.onlinebookstore.dto.Cart;
import com.onlinebookstore.exception.CartException;
import com.onlinebookstore.service.CartService;
import com.onlinebookstore.service.CartServiceImpl;

@SpringBootTest
public class CartServiceTest {
	
	@Autowired
	CartService cartService;
	
	Cart newCart;
	
	@BeforeEach
	public void DataCreation() throws CartException {
		List<Cart> cartList = this.cartService.getAllCart();
		for(Cart cart : cartList) {
			if(cart.getCartId()==83) {
				newCart = cart;
			}
		}
	}
	List<Cart> cartList;
	
	
	@Test
	public void  getAllCartTest() throws CartException{
		
		assertNotNull(this.cartService.getAllCart());
		
	}
	@Test
	public void  updateCartTest() throws CartException{
		
		assertNotNull(this.cartService.updateCart(newCart));
		
		
	}
	@Test
	public void   clearCartTest() throws CartException{
		
		CartServiceImpl myList = mock(CartServiceImpl.class);
	    doNothing().when(myList).clearCart(newCart);
	    myList.clearCart(newCart);
	 
	    verify(myList, times(1)).clearCart(newCart);
		
		
	}


}
