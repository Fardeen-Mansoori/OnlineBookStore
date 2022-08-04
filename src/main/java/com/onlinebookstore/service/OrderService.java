package com.onlinebookstore.service;

import java.util.List;


import com.onlinebookstore.dto.Order;

import com.onlinebookstore.exception.OrderException;

public interface OrderService {

	
	Order placeOrder(Order order) throws OrderException;
	Order getOrderById(Integer orderId) throws OrderException;
	String cancelOrderById(Integer orderId) throws OrderException;
	Order updateOrder(Order order) throws OrderException;
	List<Order> getAllOrders() throws OrderException;
	String deleteAllOrders() throws OrderException;
}
