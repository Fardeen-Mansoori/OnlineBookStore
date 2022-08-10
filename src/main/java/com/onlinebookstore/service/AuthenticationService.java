package com.onlinebookstore.service;

import com.onlinebookstore.dto.Admin;
import com.onlinebookstore.dto.Authentication;
import com.onlinebookstore.dto.User;
import com.onlinebookstore.exception.AdminException;
import com.onlinebookstore.exception.UserException;

public interface AuthenticationService {

	Boolean adminlogin(Authentication authentication) throws AdminException;
	Boolean userLogin(Authentication authentication) throws UserException;
	
} 
