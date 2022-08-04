package com.onlinebookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

	@GetMapping("order/{orderId}")
	public Order getOrderById(@PathVariable Integer orderId) throws OrderException {
		Order foundorder = null;
		try {
			foundorder= this.orderService.getOrderById(orderId);}
		catch(OrderException e){
			System.out.println(e.getMessage());}
		return foundorder;

	}

	@DeleteMapping("order/{orderId}")
	public String cancelOrderById(@PathVariable Integer orderId) throws OrderException {
		String foundorder="";
		try {
		foundorder= this.orderService.cancelOrderById(orderId);}
		catch(OrderException e){
			System.out.println(e.getMessage());}
		return foundorder;

	}


	@GetMapping("Orders")
	public List<Order> getAllOrders() throws OrderException {
		List<Order> foundList=null;
		try {
			foundList= this.orderService.getAllOrders();}
		catch(OrderException e) {
			System.out.println(e.getMessage());
		}
		return foundList;
	}

	
	@DeleteMapping("orders")
	public String deleteAllOrders() throws OrderException {
		String foundorders="Orders didn't deleted successfully";
		try {
		foundorders= this.orderService.deleteAllOrders();}
		catch(OrderException e){
			System.out.println(e.getMessage());}
		return foundorders;

	}
	

	@PostMapping("order/orderFromCart/{userId}")
	public Order OrderFromcart(@PathVariable Integer userId) throws OrderException {
		Order foundorder = null;
		try {
			foundorder=  this.orderService.OrderFromcart(userId);}
		catch(OrderException e){
			System.out.println(e.getMessage());}
		return foundorder;
	}
	
	@PutMapping("order")
		public Order updateOrder(@RequestBody Order order) {
			Order foundorder = null;
			try {
				foundorder = this.orderService.updateOrder(order);
			} catch (OrderException e) {
				System.out.println(e.getMessage());
			}
			return foundorder;
		}
	}

