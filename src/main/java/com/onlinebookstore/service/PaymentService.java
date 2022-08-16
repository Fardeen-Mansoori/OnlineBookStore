package com.onlinebookstore.service;

import com.onlinebookstore.dto.Payment;

import com.onlinebookstore.exception.PaymentException;

public interface PaymentService {
	
	
	Payment createPayment(Payment payment) throws PaymentException;
	Payment getPaymentById(Integer paymentId) throws PaymentException;
	

}
