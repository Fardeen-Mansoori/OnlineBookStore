package com.onlinebookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinebookstore.dao.PaymentRepository;
import com.onlinebookstore.dto.Order;
import com.onlinebookstore.dto.Payment;
import com.onlinebookstore.exception.OrderException;
import com.onlinebookstore.exception.PaymentException;

/************************************************************************************
 *          @author          Devesh Chitlangia
 *          Description      It is a service class that provides the services for creating a new payment, 
                                        and get payment bt Id.
  *         Version             1.0
  *         Created Date    18-AUG-2022
 ************************************************************************************/

@Service
public class PaymentServiceImpl implements PaymentService {
	@Autowired
	PaymentRepository paymentRepository;

	@Autowired
	OrderService orderService;
	/************************************************************************************
	 * Method: - Create Payment
	 * @Description: - It Does Payment for an order
	 * @object payment - Payment Details
	 * @returns payment - The saved entity i.e Payment 
	 * @throws  PaymentException - It is raised due to payment details are invalid, or payment
	 *                       id is not present.
	 *@throws  OrderException - It is raised due to Order details are invalid, or order
	 *                       id is not present.                  
	 ************************************************************************************/

	@Override
	public Payment createPayment(Payment payment) throws PaymentException, OrderException {
		Integer orderId = payment.getOrder().getOrderId();
		Order order = orderService.getOrderById(orderId);
		if (order.getOrderStatus().equalsIgnoreCase("Order placed Successfully")) {

			throw new PaymentException("Payment has already done for the given order");

		}
		Payment newPayment = paymentRepository.save(payment);
		order.setPayment(payment);
		order.setOrderStatus("Order placed Successfully");
		newPayment.setOrder(order);
		orderService.updateOrder(order);
		return newPayment;
	}
	/************************************************************************************
	 * Method: - Get Payment By Id
	 * @Description: - Get Payment by ID from the Book Store Application.
	 * @parameter paymentId - Unique Payment ID
	 * @returns payment - The saved entity i.e Payment 
	 * @throws  PaymentException - It is raised due to payment details are invalid, or payment
	 *                       id is not present.
	 *                       
	 ************************************************************************************/

	@Override
	public Payment getPaymentById(Integer paymentId) throws PaymentException {
		Optional<Payment> foundPayment = paymentRepository.findById(paymentId);

		if (foundPayment.isEmpty()) {
			throw new PaymentException("Payment doesn't exists for Id : " + paymentId);

		}

		return foundPayment.get();
	}
	/************************************************************************************
	 * Method: - getAllPayments
	 * @Description: - Get All Payments from the Book Store Application.
	 * @returns List<Payment> - Return List of Payments present. 
	 * @throws  PaymentException - It is raised due to payment details are invalid, or payment
	 *                       id is not present.
	 *                       
	 ************************************************************************************/
	
	@Override
	public List<Payment> getAllPayments() throws PaymentException {
		List<Payment> paymentList = paymentRepository.findAll();
		return paymentList;
	}
}
