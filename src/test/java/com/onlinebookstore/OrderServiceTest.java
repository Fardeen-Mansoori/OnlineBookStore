package com.onlinebookstore;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.onlinebookstore.dao.OrderRepository;
import com.onlinebookstore.dto.Book;
import com.onlinebookstore.dto.BookToCartItem;
import com.onlinebookstore.dto.Cart;
import com.onlinebookstore.dto.CartItem;
import com.onlinebookstore.dto.Order;
import com.onlinebookstore.dto.Payment;
import com.onlinebookstore.dto.User;
import com.onlinebookstore.exception.CartException;
import com.onlinebookstore.exception.OrderException;
import com.onlinebookstore.service.OrderService;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

@SpringBootTest
public class OrderServiceTest {
	@Autowired
	OrderService orderService;

	@Autowired
	OrderRepository orderRepository;
	
	
    
	
	List<BookToCartItem> bookToCartItemList = new ArrayList<BookToCartItem>();
	List<CartItem> cartItemList = new ArrayList<CartItem>();
	User user = new User(49, "Devesh", "12345678", "devesh@gmail.com", "Delhi,India", "1234567890", null);
    Book book = new Book(99,"Test","Testing","Tester",100.0);
    BookToCartItem bookToCartItem = new BookToCartItem(book);
	Cart cart = new Cart(290,user);
    CartItem cartItem = new CartItem(899, 10, 0.0, book, cart);
   
    Order order = null;
    
	@Test
	public void placeOrderTest() throws OrderException, CartException {
		//assertThrows(OrderException.class, () -> this.orderService.placeOrder(user, cart, "Ghaziabad"));
		bookToCartItemList.add(bookToCartItem);
		cartItem.setBookToCartItemList(bookToCartItemList);
        cartItemList.add(cartItem);
        cart.setCartItemList(cartItemList);
        assertNotNull(orderService.placeOrder(user, cart, "Ghaziabad"));
		
		
		
		//assertNotNull(order);
	}

	@Test
	public void cancelOrderByIdTest() throws OrderException, CartException {
		
		
		assertEquals("Successful", this.orderService.cancelOrderById(344));
		assertThrows(OrderException.class, () -> this.orderService.cancelOrderById(501));
	}

	@Test
	public void getOrderByIdTest() throws OrderException, CartException {
		
		
		
		assertNotNull(orderService.getOrderById(111));
		assertThrows(OrderException.class, () -> this.orderService.getOrderById(501));

	}

	@Test
	public void updateOrderTest() throws OrderException, CartException {
		Order newOrder = orderService.getOrderById(111);
		newOrder.setShippingAddress("asdfghjk");
		assertNotNull(orderService.updateOrder(newOrder));
		assertEquals("asdfghjk", orderService.getOrderById(newOrder.getOrderId()).getShippingAddress());
		assertThrows(OrderException.class, () -> this.orderService.updateOrder(null));
	}

	@Test
	public void getAllOrdersTest() throws OrderException, CartException {
		
		
		assertNotNull(orderService.getAllOrders());

	}

}