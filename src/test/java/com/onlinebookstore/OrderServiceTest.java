package com.onlinebookstore;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.onlinebookstore.dto.Order;
import com.onlinebookstore.exception.BookException;
import com.onlinebookstore.exception.OrderException;
import com.onlinebookstore.service.OrderService;
import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.AfterEach;
@SpringBootTest
public class OrderServiceTest {
@Autowired
OrderService orderService;

Order order = new Order("abc",null,null);
@Test
public void placeOrderTest() throws OrderException {
	
	//Order order = new Order("abc",null,null,null,null);
	//assertEquals(orderService.placeOrder(order));
	assertNotNull(orderService.placeOrder(order));
	assertThrows(BookException.class,()-> this.orderService.placeOrder(order));
}
@AfterEach
public void cancelOrderByIdTest() throws OrderException{
	
	assertEquals( "Successful", this.orderService.cancelOrderById(order.getOrderId()));
	assertThrows(BookException.class,()-> this.orderService.cancelOrderById(501));
}

@Test
public void getOrderByIdTest() throws OrderException{
	//Order order = new Order("abc",null,null,null,null);
	assertNotNull(orderService.placeOrder(order));
	assertNotNull(orderService.getOrderById(order.getOrderId()));
	assertThrows(BookException.class,()-> this.orderService.getOrderById(501));

}

@Test
public void updateOrderTest() throws OrderException{
	//Order order = new Order("abc",null,null,null,null);
	assertNotNull(orderService.placeOrder(order));
	assertNotNull(orderService.updateOrder(order));
	assertThrows(BookException.class,()-> this.orderService.updateOrder(order));
}


@Test
public void getAllOrdersTest() throws OrderException, BookException{
	assertNotNull(orderService.placeOrder(order));
	assertNotNull(orderService.getAllOrders());
	assertThrows(BookException.class,()-> this.orderService.getAllOrders());

}


}