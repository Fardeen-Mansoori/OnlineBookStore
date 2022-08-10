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
	@Override
	public Boolean adminlogin(Authentication authentication) throws AdminException {
		Integer adminIdInteger=authentication.getId();
		String password=authentication.getPassword();
		this.adminService.login(adminIdInteger, password);
		return true;
	}

	@Override
	public Boolean userLogin(Authentication authentication) throws UserException {
		// TODO Auto-generated method stub
		return null;
	}

}
