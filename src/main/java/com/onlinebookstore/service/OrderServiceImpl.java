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
import com.onlinebookstore.dto.User;
import com.onlinebookstore.exception.CartException;
import com.onlinebookstore.exception.OrderException;

/************************************************************************************
 *          @author         Faisal khan
 *          Description      It is a service class that provides the services for creating a new Order, get Order by Id,
 *          cancel order , get all orders, update order
 *          Version             1.0
 *          Created Date    16-AUG-2022
 ************************************************************************************/
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

	/************************************************************************************
	 * Method: - Place order 
	 * Description: - Placing order using UserId, Shipping Address
	 * 
	 * @Parameter User - User detail
	 * @Parameter Shipping Address - Address to deliver the Order
	 * @returns Order - Updated order
	 * @throws OrderException - It is raised due to Order details are invalid, or Order
	 *                       id is not present.
	 ************************************************************************************/

	
	
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

	/************************************************************************************
	 * Method: - Get order
	 * Description: - Fetch order using orderId
	 * @Parameter OrderId - Unique Id of order
	 * @returns Order - Updated order
	 * @throws OrderException - It is raised due to Order details are invalid, or Order
	 *                       id is not present.
	 ************************************************************************************/

	@Override
	public Order getOrderById(Integer orderId) throws OrderException {
		Optional<Order> foundOrder = this.orderRepository.findById(orderId);
		if (foundOrder.isEmpty()) {
			throw new OrderException("Order doesnot exists for id " + orderId);
		}
		return foundOrder.get();
	}

	/************************************************************************************
	 * Method: - Cancel order 
	 * Description: - Canceling order using OrderId
	 * @Parameter OrderId - Unique Id of order
	 * @returns String - Return If order cancel successfully or not
	 * @throws OrderException - It is raised due to Order details are invalid, or Order
	 *                       id is not present.
	 ************************************************************************************/

	@Override
	public String cancelOrderById(Integer orderId) throws OrderException {
		String isDeleted;
		Optional<Order> foundOrder = orderRepository.findById(orderId);
		if (foundOrder.isEmpty()) {
			throw new OrderException("Order does not exist for id " + orderId);
		} 
		foundOrder.get().setOrderStatus("order cancelled");
		Order updatedOrder = this.orderRepository.save(foundOrder.get());
		isDeleted = "Order Cancelled Successfully";
		return isDeleted;
	}

	/************************************************************************************
	 * Method: - Fetching all orders
	 * Description: - Fetching all orders 
	 * @returns List<Order> - Return List of all orders
	 * @throws OrderException - It is raised due to Order details are invalid, or Order
	 *                       id is not present.
	 ************************************************************************************/

	@Override
	public List<Order> getAllOrders() throws OrderException {
		// TODO Auto-generated method stub
		List<Order> orderList = orderRepository.findAll();
		if (orderList.isEmpty()) {
			throw new OrderException("No orders found!");
		}
		return orderList;

	}

	/************************************************************************************
	 * Method: - Update order 
	 * Description: - Updating order using Order Details
	 * @object Order - Details of order
	 * @returns Order - Updated order
	 * @throws OrderException - It is raised due to Order details are invalid, or Order
	 *                       id is not present.
	 ************************************************************************************/
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
