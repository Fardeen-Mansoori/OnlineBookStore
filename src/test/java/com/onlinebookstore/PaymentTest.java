package com.onlinebookstore;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.onlinebookstore.dto.Payment;
import com.onlinebookstore.exception.PaymentException;
import com.onlinebookstore.service.PaymentService;

@SpringBootTest
public class PaymentTest {
@Autowired
PaymentService paymentServiice;

@Test
public void createPaymentTest() throws PaymentException{
	Payment payment = new Payment();
	assertNotNull(paymentServiice.createPayment(payment));
}
	
	

}
