
package com.onlinebookstore.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.onlinebookstore.exception.UserException;
@RestControllerAdvice
public class UserControllerAdvice {
	@ExceptionHandler(UserException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public String handleUserException(UserException e) {
		return e.getMessage();

}
}