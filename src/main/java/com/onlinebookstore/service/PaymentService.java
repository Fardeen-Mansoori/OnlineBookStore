package com.onlinebookstore.service;


import com.onlinebookstore.dto.Payment;
import com.onlinebookstore.exception.OrderException;
import com.onlinebookstore.exception.PaymentException;

public interface PaymentService {
	
	
	Payment createPayment(Payment payment) throws PaymentException, OrderException;
	Payment getPaymentById(Integer paymentId) throws PaymentException;
	

}
