
package com.onlinebookstore.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.http.HttpStatus;

import com.onlinebookstore.exception.OrderException;

@RestControllerAdvice
public class OrderControllerAdvice {
	@ExceptionHandler(OrderException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public String handleOrderException(OrderException e) {
		return e.getMessage();

	}

}
