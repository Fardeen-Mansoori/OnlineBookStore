package com.onlinebookstore.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.onlinebookstore.dto.Authentication;
import com.onlinebookstore.exception.AdminException;
import com.onlinebookstore.exception.UserException;
/************************************************************************************
 * @author Devesh Chitlangia
 * @Description It is a service class that provides the services for creating a
 *              new user, get user by ID, Update User and Get All Users. Version
 *              1.0 Created Date 16-AUG-2022
 ************************************************************************************/
@Service
public class AuthenticationServiceImpl implements AuthenticationService {

	@Autowired
	private AdminService adminService;
	@Autowired
	UserService userService;
	/************************************************************************************
	 * Method: - Add User Description: - Registered User in the Book Store
	 * Application.
	 * 
	 * @object User - User detail
	 * @returns the saved entity, if user registered otherwise throws UserException
	 *          Exception
	 * @throws UserException - It is raised due to User details are invalid or null     
	 ************************************************************************************/
	
	@Override
	public Boolean adminlogin(Authentication authentication) throws AdminException {
		Integer adminId=authentication.getId();
		String adminPassword=authentication.getPassword();
		this.adminService.login(adminId, adminPassword);
		return true;
	}
	/************************************************************************************
	 * Method: - Add User Description: - Registered User in the Book Store
	 * Application.
	 * 
	 * @object User - User detail
	 * @returns the saved entity, if user registered otherwise throws UserException
	 *          Exception
	 * @throws UserException - It is raised due to User details are invalid or null     
	 ************************************************************************************/

	@Override
	public Boolean userLogin(Authentication authentication) throws UserException {
		Integer userId=authentication.getId();
		String userpassword=authentication.getPassword();
		this.userService.login(userId, userpassword);
		return true;
	}

}
