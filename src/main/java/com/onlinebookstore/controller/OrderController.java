package com.onlinebookstore.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.onlinebookstore.dto.Cart;
import com.onlinebookstore.dto.Order;
import com.onlinebookstore.dto.Payment;
import com.onlinebookstore.dto.User;
import com.onlinebookstore.exception.CartException;
import com.onlinebookstore.exception.OrderException;
import com.onlinebookstore.exception.PaymentException;
import com.onlinebookstore.exception.UserException;
import com.onlinebookstore.service.CartService;
import com.onlinebookstore.service.OrderService;
import com.onlinebookstore.service.PaymentService;
import com.onlinebookstore.service.UserService;

@RestController
public class OrderController {
	@Autowired
	OrderService orderService;

	@Autowired
	UserService userService;

	@Autowired
	CartService cartService;

	@Autowired
	PaymentService paymentService;

	@PostMapping("order/{userId}/{shippingAddress}/{paymentId}")
	public Order placeOrder(@Valid @PathVariable Integer userId, @PathVariable String shippingAddress,
			@PathVariable Integer paymentId) throws OrderException, UserException, PaymentException, CartException {
		User user = userService.getUserById(userId);
		Cart cart = user.getCart();
		Payment payment = paymentService.getPaymentById(paymentId);

		return orderService.placeOrder(user, cart, shippingAddress, payment);
	}

	@GetMapping("order/{orderId}")
	public Order getOrderById(@PathVariable Integer orderId) throws OrderException {
		Order foundorder = null;
		try {
			foundorder = this.orderService.getOrderById(orderId);
		} catch (OrderException e) {
			throw new OrderException(e.getMessage());
		}
		return foundorder;

	}

	@DeleteMapping("order/{orderId}")
	public String cancelOrderById(@PathVariable Integer orderId) throws OrderException {
		String foundorder = "Order not deleted";
		try {
			foundorder = this.orderService.cancelOrderById(orderId);
		} catch (OrderException e) {
			throw new OrderException(e.getMessage());
		}
		return foundorder;

	}

	@GetMapping("Orders")
	public List<Order> getAllOrders() throws OrderException {
		List<Order> foundList = null;
		try {
			foundList = this.orderService.getAllOrders();
		} catch (OrderException e) {
			throw new OrderException(e.getMessage());
		}
		return foundList;
	}

	@PutMapping("order")
	public Order updateOrder(@Valid @RequestBody Order order) throws OrderException {
		Order foundorder = null;
		try {
			foundorder = this.orderService.updateOrder(order);
		} catch (OrderException e) {
			throw new OrderException(e.getMessage());
		}
		return foundorder;
	}
}
