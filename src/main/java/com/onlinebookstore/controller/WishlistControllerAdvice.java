package com.onlinebookstore.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.http.HttpStatus;


import com.onlinebookstore.exception.WishlistException;

@RestControllerAdvice
public class WishlistControllerAdvice {
	@ExceptionHandler(WishlistException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public String handleWishlistException(WishlistException e) {
		return e.getMessage();

	}
}
