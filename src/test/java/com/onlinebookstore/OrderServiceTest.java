package com.onlinebookstore;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.onlinebookstore.dao.OrderRepository;
import com.onlinebookstore.dto.Cart;
import com.onlinebookstore.dto.Order;
import com.onlinebookstore.dto.Payment;
import com.onlinebookstore.dto.User;
import com.onlinebookstore.exception.CartException;
import com.onlinebookstore.exception.OrderException;
import com.onlinebookstore.service.OrderService;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
public class OrderServiceTest {
@Autowired
OrderService orderService;

@Autowired
OrderRepository orderRepository;

User user = new User(49,"Devesh","12345678","devesh@gmail.com","Delhi,India","1234567890",null);
Cart cart = user.getCart();
@Test
public void placeOrderTest() throws OrderException, CartException {

	assertNotNull(orderService.placeOrder(user,cart,"Ghaziabad"));
	assertThrows(OrderException.class,()-> this.orderService.placeOrder(user,cart,"Ghaziabad"));
}
@Test
public void cancelOrderByIdTest() throws OrderException, CartException{
	
	Order order = orderService.placeOrder(user,cart,"Ghaziabad");
	assertEquals("Successful", this.orderService.cancelOrderById(order.getOrderId()));
	assertThrows(OrderException.class,()-> this.orderService.cancelOrderById(501));
}

@Test
public void getOrderByIdTest() throws OrderException, CartException{
	Order order = orderService.placeOrder(user,cart,"Ghaziabad");
	assertNotNull(order);
	assertNotNull(orderService.getOrderById(order.getOrderId()));
	assertThrows(OrderException.class,()-> this.orderService.getOrderById(501));

}

@Test
public void updateOrderTest() throws OrderException, CartException{
	Order order = orderService.placeOrder(user,cart,"Ghaziabad");
	order.setShippingAddress("asdfghjk");
	assertNotNull(orderService.updateOrder(order));
	assertEquals("asdfghjk",orderService.getOrderById(order.getOrderId()).getShippingAddress());
	assertThrows(OrderException.class,()-> this.orderService.updateOrder(null));
}


@Test
public void getAllOrdersTest() throws OrderException, CartException{
	Order order = orderService.placeOrder(user,cart,"Ghaziabad");
	assertNotNull(order);
	assertNotNull(orderService.getAllOrders());
	

}



}