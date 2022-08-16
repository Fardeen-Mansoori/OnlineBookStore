package com.onlinebookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.onlinebookstore.dto.Admin;
import com.onlinebookstore.dto.Authentication;
import com.onlinebookstore.dto.User;
import com.onlinebookstore.exception.AdminException;
import com.onlinebookstore.exception.UserException;
import com.onlinebookstore.service.AuthenticationService;

@RestController
public class AuthenticationController {
	@Autowired
	AuthenticationService authenticationService;
	
	
	@PostMapping("admin/login")
	public Boolean adminlogin(@RequestBody Authentication authentication) throws AdminException {
		return this.authenticationService.adminlogin(authentication);

	}
	
	@PostMapping("user/login")
	public Boolean userLogin(@RequestBody Authentication authentication) throws UserException {
		return this.authenticationService.userLogin(authentication);

	}
}
