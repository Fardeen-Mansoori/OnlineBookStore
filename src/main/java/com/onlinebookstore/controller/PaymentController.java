package com.onlinebookstore.controller;

import java.util.List;

import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.onlinebookstore.dto.Payment;
import com.onlinebookstore.exception.OrderException;
import com.onlinebookstore.exception.PaymentException;
import com.onlinebookstore.service.OrderService;
import com.onlinebookstore.service.PaymentService;

@RestController
public class PaymentController {

	@Autowired
	 PaymentService paymentService;
	
	@Autowired
	OrderService orderService;

	@PostMapping("payment")
	public Payment createPayment(@Valid @RequestBody Payment payment ) throws PaymentException,  OrderException, MethodArgumentNotValidException{
		  
			return this.paymentService.createPayment(payment);
		
	}

	@GetMapping("payment/{paymentId}")
	public Payment getPaymentById(@PathVariable Integer paymentId) throws PaymentException {
		return this.paymentService.getPaymentById(paymentId);

	}
	
	@GetMapping("payments")
	public List<Payment> getAllPayments() throws PaymentException {
		return this.paymentService.getAllPayments();
	}

}
