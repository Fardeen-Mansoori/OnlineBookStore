package com.onlinebookstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinebookstore.dto.Authentication;
import com.onlinebookstore.exception.AdminException;
import com.onlinebookstore.exception.UserException;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

	@Autowired
	private AdminService adminService;
	@Autowired
	UserService userService;
	
	@Override
	public Boolean adminlogin(Authentication authentication) throws AdminException {
		Integer adminId=authentication.getId();
		String adminPassword=authentication.getPassword();
		this.adminService.login(adminId, adminPassword);
		return true;
	}

	@Override
	public Boolean userLogin(Authentication authentication) throws UserException {
		Integer userId=authentication.getId();
		String userpassword=authentication.getPassword();
		this.userService.login(userId, userpassword);
		return true;
	}

}
