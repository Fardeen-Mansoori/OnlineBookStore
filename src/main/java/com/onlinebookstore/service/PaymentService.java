package com.onlinebookstore.service;

import com.onlinebookstore.dto.Payment;
import com.onlinebookstore.dto.UserPayment;
import com.onlinebookstore.exception.PaymentException;

public interface PaymentService {
	
	Payment setByUserPayment(UserPayment userPayment, Payment payment) throws PaymentException;
	Payment createPayment(Payment payment) throws PaymentException;
	Payment getPaymentById(Integer paymentId) throws PaymentException;
	

}
