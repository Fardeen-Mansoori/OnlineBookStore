package com.onlinebookstore.controller;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.onlinebookstore.exception.BookException;

@RestControllerAdvice
public class BookControllerAdvice {
	@ExceptionHandler(BookException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public String handleBookException(BookException e) {
		return e.getMessage();

	}
}


