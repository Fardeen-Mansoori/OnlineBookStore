package com.onlinebookstore;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.onlinebookstore.dto.Order;
import com.onlinebookstore.dto.Payment;
import com.onlinebookstore.exception.OrderException;
import com.onlinebookstore.exception.PaymentException;
import com.onlinebookstore.service.OrderService;
import com.onlinebookstore.service.PaymentService;

@SpringBootTest
public class PaymentTest {
	@Autowired
	PaymentService paymentService;

	@Autowired
	OrderService orderService;
	
	Order order;
	

	Payment payment;
	@BeforeEach
	public void dataCreation() throws OrderException {
		order = this.orderService.getOrderById(344);
		payment = new Payment("card payment","visa card","1234567890123456",12,2028,123,"faisal",order);
	}

	@Test
	public void createPaymentTest() throws PaymentException, OrderException {
		
		//payment = paymentService.createPayment(payment);
		//assertNotNull(payment);
		assertThrows(PaymentException.class, () -> paymentService.createPayment(payment));
	}

	@Test
	public void getPaymentByIdTest() throws PaymentException, OrderException {
		
		assertNotNull(paymentService.getPaymentById(order.getPayment().getPaymentId()));
		assertThrows(PaymentException.class,()-> paymentService.getPaymentById(200));
	}

}
