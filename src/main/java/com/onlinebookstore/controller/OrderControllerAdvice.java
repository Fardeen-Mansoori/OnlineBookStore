
package com.onlinebookstore.controller;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;

import com.onlinebookstore.exception.OrderException;

@RestControllerAdvice
public class OrderControllerAdvice {
	@ExceptionHandler(OrderException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public String handleOrderException(OrderException e) {
		return e.getMessage();

	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {

		Map<String, String> errors = new HashMap<>();

		ex
		.getBindingResult()
		.getAllErrors()
		.forEach(
				(error) -> {
							String fieldName = ((FieldError) error).getField();
							String errorMessage = error.getDefaultMessage();
							errors.put(fieldName, errorMessage);
							}
				);
		
		return errors;
	}


}
