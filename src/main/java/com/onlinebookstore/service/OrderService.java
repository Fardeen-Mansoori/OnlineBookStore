package com.onlinebookstore.service;

import java.util.List;

import com.onlinebookstore.dto.Cart;
import com.onlinebookstore.dto.Order;
import com.onlinebookstore.dto.Payment;
import com.onlinebookstore.dto.User;
import com.onlinebookstore.exception.CartException;
import com.onlinebookstore.exception.OrderException;

public interface OrderService {

	Order placeOrder(User user, Cart cart, String shippingAddress)
			throws OrderException, CartException;

	Order getOrderById(Integer orderId) throws OrderException;

	String cancelOrderById(Integer orderId) throws OrderException;

	Order updateOrder(Order order) throws OrderException;

	List<Order> getAllOrders() throws OrderException;

}
