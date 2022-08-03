package com.onlinebookstore;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.onlinebookstore.dto.Order;
import com.onlinebookstore.dto.Payment;
import com.onlinebookstore.dto.UserBilling;
import com.onlinebookstore.exception.PaymentException;
import com.onlinebookstore.service.PaymentService;

@SpringBootTest
public class PaymentTest {
@Autowired
PaymentService paymentServiice;

@Test
public void createPaymentTest() throws PaymentException{
	//String type, String cardName, String cardNumber, int expiryMonth, int expiryYear,
	//int cvc, String holderName, Order order, UserBilling userBilling
	
	Payment payment = new Payment("","","",0,0,0,"",null,null);
	assertNotNull(paymentServiice.createPayment(payment));
}
	
	

}
