package com.onlinebookstore;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.onlinebookstore.dto.Order;
import com.onlinebookstore.dto.Payment;
import com.onlinebookstore.exception.OrderException;
import com.onlinebookstore.exception.PaymentException;
import com.onlinebookstore.service.PaymentService;

@SpringBootTest
public class PaymentTest {
	@Autowired
	PaymentService paymentService;

	
	Order order = new Order();

	Payment payment = new Payment(699,"card payment","visa card","1234567890123456",12,2028,123,"faisal",order);

	@Test
	public void createPaymentTest() throws PaymentException, OrderException {
		order.setOrderId(399);
		payment = paymentService.createPayment(payment);
		assertNotNull(payment);
		assertThrows(PaymentException.class, () -> paymentService.getPaymentById(payment.getPaymentId() + 1));
	}

	@Test
	public void getPaymentByIdTest() throws PaymentException, OrderException {
		
		assertNotNull(paymentService.getPaymentById(payment.getPaymentId()));
		assertThrows(PaymentException.class,()-> paymentService.getPaymentById(200));
	}

}
