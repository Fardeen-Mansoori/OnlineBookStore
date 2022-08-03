package com.onlinebookstore.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.onlinebookstore.exception.CartException;

@RestControllerAdvice
public class CartControllerAdvice {
	@ExceptionHandler(CartException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public String handleCartException(CartException e) {
		return e.getMessage();

	}

}
