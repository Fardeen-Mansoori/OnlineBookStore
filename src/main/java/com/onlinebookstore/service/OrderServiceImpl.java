package com.onlinebookstore.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinebookstore.dao.CartRepository;
import com.onlinebookstore.dao.OrderRepository;
import com.onlinebookstore.dto.Cart;
import com.onlinebookstore.dto.CartItem;
import com.onlinebookstore.dto.Order;
import com.onlinebookstore.dto.Payment;
import com.onlinebookstore.dto.User;
import com.onlinebookstore.exception.CartException;
import com.onlinebookstore.exception.OrderException;

@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	OrderRepository orderRepository;

	@Autowired
	CartRepository cartRepository;

	@Autowired
	CartItemService cartItemService;
	
	@Autowired 
	CartService cartService;

	@Override
	public Order placeOrder(User user, Cart cart, String shippingAddress) throws OrderException, CartException {
		if(cart.getCartItemList().isEmpty()) {
			throw new OrderException("Order cannot be placed, cart is empty");
		}

		Order order = new Order();

		order.setOrderStatus("created");
		order.setShippingAddress(shippingAddress);

		List<CartItem> cartItemList = cartItemService.findByCart(cart);

		for (CartItem cartItem : cartItemList) {

			cartItem.setOrder(order);

		}

		order.setCartItemList(cartItemList);
		order.setOrderDate(LocalDate.now());
		order.setDeliveryDate(order.getOrderDate().plusDays(7));
		order.setOrderTotal(cart.getCartTotal());

		
		order.setUser(user);
		order = orderRepository.save(order);
		cartService.clearCart(cart);
		return order;

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

}
