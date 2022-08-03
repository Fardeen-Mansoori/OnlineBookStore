
package com.onlinebookstore.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.onlinebookstore.exception.CategoryException;

@RestControllerAdvice
public class CategoryControllerAdvice {
	@ExceptionHandler(CategoryException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public String handleCategoryException(CategoryException e) {
		return e.getMessage();

	}
}
