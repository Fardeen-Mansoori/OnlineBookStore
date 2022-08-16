package com.onlinebookstore.service;

import java.util.List;
import java.util.Optional;

import javax.annotation.Generated;
import javax.persistence.GeneratedValue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ser.std.StdKeySerializers.Default;
import com.onlinebookstore.dao.CartRepository;
import com.onlinebookstore.dao.OrderRepository;
import com.onlinebookstore.dao.UserRepository;
import com.onlinebookstore.dto.Cart;
import com.onlinebookstore.dto.Order;
import com.onlinebookstore.dto.User;
import com.onlinebookstore.exception.OrderException;

@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	OrderRepository orderRepository;

	@Autowired
	CartRepository cartRepository;

	
	@Override
	public Order placeOrder(Order order) throws OrderException {

//	Order orderCreated = null;
//	orderCreated = this.orderRepository.save(order);
//	return orderCreated;
		if (order == null) {
			throw new OrderException("Order cannot be null");
		}
		//this.cartRepository.deleteAll();
		return this.orderRepository.save(order);
	}

	@Override
	public Order getOrderById(Integer orderId) throws OrderException {
		Optional<Order> foundOrder = this.orderRepository.findById(orderId);
		if (foundOrder.isEmpty()) {
			throw new OrderException("Order doesnot exists for id " + orderId);
		}
		return foundOrder.get();
	}

	@Override
	public String cancelOrderById(Integer orderId) throws OrderException {
		String isDeleted;
		Optional<Order> foundOrder = orderRepository.findById(orderId);
		if (foundOrder.isEmpty()) {
			throw new OrderException("Order does not exist for id " + orderId);
		} else {
			orderRepository.delete(foundOrder.get());
			isDeleted = "Successful";
		}
		return isDeleted;
	}

	@Override
	public List<Order> getAllOrders() throws OrderException {
		// TODO Auto-generated method stub
		List<Order> orderList = orderRepository.findAll();
		if (orderList.isEmpty()) {
			throw new OrderException("No orders found!");
		}
		return orderList;

	}

	@Override
	public Order updateOrder(Order order) throws OrderException {
		if (order == null) {
			throw new OrderException("Order cannot be null");
		}
		Optional<Order> foundOrder = this.orderRepository.findById(order.getOrderId());
		if (foundOrder.isEmpty()) {
			throw new OrderException("Order doesnot exists for id " + order.getOrderId());
		}
		return this.orderRepository.save(order);
	}

	@Override
	public String deleteAllOrders() throws OrderException {
		this.orderRepository.deleteAll();
		return "deleted successfully";
	}

	@Override
	public Order OrderFromcart(Integer cartId) throws OrderException {
		if(cartId==null) {
			throw new OrderException("Enter valid userId");
		}
		Optional<Cart> cart = this.cartRepository.findById(cartId);
		
		if(cart.isEmpty()) {
			throw new OrderException("Cart doesnot exist for cartid"+cartId);
		}
		Order order = new Order();
		//List<Order> orders=this.orderRepository.findAll();
		//Order lastElement=orders.get(orders.size() - 1);
		//Integer orderId=lastElement.orderId;
		//order.setOrderId(orderId+1);
        order.setBook(cart.get().getBook());
		order.setShippingAddress(cart.get().getUser().getUserAddress());
		order.setUser(cart.get().getUser());
		return placeOrder(order);
		//this.orderRepository.save(order);
		//return order;
	}

}
