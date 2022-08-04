package com.onlinebookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.onlinebookstore.dto.Order;

import com.onlinebookstore.exception.OrderException;
import com.onlinebookstore.service.OrderService;

@RestController
public class OrderController {
	@Autowired
	OrderService orderService;

	@PostMapping("order/place")
	public Order placeOrder(@RequestBody Order order) {
		Order foundorder = null;
		try {
			foundorder = this.orderService.placeOrder(order);
		} catch (OrderException e) {
			System.out.println(e.getMessage());
		}
		return foundorder;

	}

	@GetMapping("order/get/{orderId}")
	public Order getOrderById(@PathVariable Integer orderId) throws OrderException {
		return this.orderService.getOrderById(orderId);

	}

	@DeleteMapping("order/cancel/{orderId}")
	public String cancelOrderById(@PathVariable Integer orderId) throws OrderException {
		return this.orderService.cancelOrderById(orderId);

	}

	@GetMapping("order/orders")
	public List<Order> getAllOrders() throws OrderException {
		return this.orderService.getAllOrders();
	}

	
	@DeleteMapping("order/delete/orders")
	public String deleteAllOrders() throws OrderException {
		return this.orderService.deleteAllOrders();

	}
	
	@PostMapping("order/placeThroughCart/{userId}")
	public Order OrderFromcart(@PathVariable Integer userId) throws OrderException {
		return this.orderService.OrderFromcart(userId);
	}
}
