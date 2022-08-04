package com.onlinebookstore;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.onlinebookstore.dto.Payment;

import com.onlinebookstore.exception.PaymentException;
import com.onlinebookstore.service.PaymentService;

@SpringBootTest
public class PaymentTest {
	@Autowired
	PaymentService paymentService;

	Payment payment = new Payment("", "", "", 0, 0, 0, "", null, null);

	@Test
	public void createPaymentTest() throws PaymentException {
		// String type, String cardName, String cardNumber, int expiryMonth, int
		// expiryYear,
		// int cvc, String holderName, Order order, UserBilling userBilling
		assertNotNull(paymentService.createPayment(payment));
		assertThrows(PaymentException.class, () -> paymentService.getPaymentById(payment.getPaymentId() + 1));
	}

	@Test
	public void getPaymentByIdTest() throws PaymentException {
		assertNotNull(paymentService.createPayment(payment));
		assertNotNull(paymentService.getPaymentById(payment.getPaymentId()));
		assertThrows(PaymentException.class,()-> paymentService.getPaymentById(200));
	}

}
