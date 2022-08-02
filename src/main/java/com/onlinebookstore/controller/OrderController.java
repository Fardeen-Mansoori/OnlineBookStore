package com.onlinebookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.onlinebookstore.dto.Book;
import com.onlinebookstore.dto.Order;
import com.onlinebookstore.exception.BookException;
import com.onlinebookstore.exception.OrderException;
import com.onlinebookstore.service.OrderService;
@RestController
public class OrderController {
@Autowired
OrderService orderService;
	@PostMapping("order")
	public Order placeOrder(@RequestBody Order order) {
		Order foundorder=null;
		try {
			foundorder=this.orderService.placeOrder(order);
		} catch (OrderException e) {
			System.out.println(e.getMessage());
		}
		return foundorder;
		
	}
	
	@GetMapping("order/{orderId}")
	public Order getOrderById(@PathVariable Integer orderId) throws OrderException {
		return this.orderService.getOrderById(orderId);

	}
	
	@DeleteMapping("order/{orderId}")
	public String cancelOrderById(@PathVariable Integer orderId) throws OrderException {
		return this.orderService.cancelOrderById(orderId);
		
	}
	
	
	@GetMapping("allorders")
	public List<Order> getAllOrders() throws BookException{
		return this.orderService.getAllOrders();
	}
	
	
}
