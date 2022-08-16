package com.onlinebookstore;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.onlinebookstore.dao.OrderRepository;
import com.onlinebookstore.dto.Order;
import com.onlinebookstore.dto.Payment;
import com.onlinebookstore.exception.OrderException;
import com.onlinebookstore.service.OrderService;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
public class OrderServiceTest {
@Autowired
OrderService orderService;

@Autowired
OrderRepository orderRepository;

Payment payment = new Payment();
Order order = new Order("abc",null,null, payment);

@Test
public void placeOrderTest() throws OrderException {
	
	//Order order = new Order("abc",null,null,null,null);
	//assertEquals(orderService.placeOrder(order));
	assertNotNull(orderService.placeOrder(order));
	assertThrows(OrderException.class,()-> this.orderService.placeOrder(null));
}
@Test
public void cancelOrderByIdTest() throws OrderException{
	//Order newOrder = new Order("def",null,null);
	assertNotNull(orderService.placeOrder(order));
	assertEquals("Successful", this.orderService.cancelOrderById(order.getOrderId()));
	assertThrows(OrderException.class,()-> this.orderService.cancelOrderById(501));
}

@Test
public void getOrderByIdTest() throws OrderException{
	//Order order = new Order("abc",null,null,null,null);
	assertNotNull(orderService.placeOrder(order));
	assertNotNull(orderService.getOrderById(order.getOrderId()));
	assertThrows(OrderException.class,()-> this.orderService.getOrderById(501));

}

@Test
public void updateOrderTest() throws OrderException{
	//Order order = new Order("abc",null,null,null,null);
	assertNotNull(orderService.placeOrder(order));
	order.setShippingAddress("asdfghjk");
	assertNotNull(orderService.updateOrder(order));
	assertEquals("asdfghjk",order.getShippingAddress());
	assertThrows(OrderException.class,()-> this.orderService.updateOrder(null));
}


@Test
public void getAllOrdersTest() throws OrderException{
	assertNotNull(orderService.placeOrder(order));
	assertNotNull(orderService.getAllOrders());
	this.orderRepository.deleteAll();
	assertThrows(OrderException.class,()-> this.orderService.getAllOrders());

}



//hello
}