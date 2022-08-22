package com.onlinebookstore.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.onlinebookstore.dto.Payment;

import com.onlinebookstore.exception.PaymentException;
import com.onlinebookstore.service.PaymentService;

@RestController
public class PaymentController {

	@Autowired
	 PaymentService paymentService;

	@PostMapping("payment")
	public Payment createPayment(@Valid @RequestBody Payment payment) throws PaymentException {
		Payment foundPayment = null;
		try {
			foundPayment = this.paymentService.createPayment(payment);
		} catch (PaymentException e) {
			System.out.println(e.getMessage());
		}
		return foundPayment;

	}

	@GetMapping("payment/{paymentId}")
	public Payment getPaymentById(@PathVariable Integer paymentId) throws PaymentException {
		return this.paymentService.getPaymentById(paymentId);

	}

}
