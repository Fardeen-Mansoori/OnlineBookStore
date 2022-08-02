package com.onlinebookstore;
import static org.hamcrest.CoreMatchers.nullValue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.onlinebookstore.dto.Order;
import com.onlinebookstore.exception.BookException;
import com.onlinebookstore.exception.OrderException;
import com.onlinebookstore.service.OrderService;
import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
@SpringBootTest
public class OrderServiceTest {
@Autowired
OrderService orderService;

Order order = new Order("abc",null,null,null,null);
@Test
public void placeOrderTest() throws OrderException {
	
	//Order order = new Order("abc",null,null,null,null);
	//assertEquals(orderService.placeOrder(order));
	assertNotNull(orderService.placeOrder(order));
	
}
@AfterEach
public void cancelOrderByIdTest() throws OrderException{
	
	assertEquals( "Successful", this.orderService.cancelOrderById(order.getOrderId()));
	
}

@Test
public void getOrderByIdTest() throws OrderException{
	//Order order = new Order("abc",null,null,null,null);
	assertNotNull(orderService.placeOrder(order));
	assertNotNull(orderService.getOrderById(order.getOrderId()));
	
}

@Test
public void updateOrderTest() throws OrderException{
	//Order order = new Order("abc",null,null,null,null);
	assertNotNull(orderService.placeOrder(order));
	assertNotNull(orderService.updateOrder(order));
	
}


@Test
public void getAllOrdersTest() throws OrderException, BookException{
	assertNotNull(orderService.placeOrder(order));
	assertNotNull(orderService.getAllOrders());
}


}