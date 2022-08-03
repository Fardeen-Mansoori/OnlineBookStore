
package com.onlinebookstore.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.onlinebookstore.exception.PaymentException;

@RestControllerAdvice
public class PaymentControllerAdvice {
	@ExceptionHandler(PaymentException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public String handlePaymentException(PaymentException e) {
		return e.getMessage();

	}
}