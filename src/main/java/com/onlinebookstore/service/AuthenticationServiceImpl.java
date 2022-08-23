package com.onlinebookstore.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.onlinebookstore.dto.Authentication;
import com.onlinebookstore.exception.AdminException;
import com.onlinebookstore.exception.UserException;
/************************************************************************************
 * @author Faisal Khan
 * @Description It is a service class that provides the services for Authenticating user and Admin 
 *     
 *              Version 1.0 Created Date 20-AUG-2022
 * @Date 18th August 2022
 ************************************************************************************/
@Service
public class AuthenticationServiceImpl implements AuthenticationService {

	@Autowired
	private AdminService adminService;
	@Autowired
	UserService userService;
	/************************************************************************************
	 * Method: - Admin Login 
	 * Description: - Login of Admin in Book Store Application.
	 * @object Authentication - Admin Details
	 * @returns Boolean - True if Admin get Login otherwise false.
	 * @throws AdminException - It is raised due to Admin details are invalid or null     
	 ************************************************************************************/
	
	@Override
	public Boolean adminlogin(Authentication authentication) throws AdminException {
		Integer adminId=authentication.getId();
		String adminPassword=authentication.getPassword();
		this.adminService.login(adminId, adminPassword);
		return true;
	}
	/************************************************************************************
	 * Method: - User Login
	 * Description: - Login of User in Book Store Application. 
	 * @object Authenticatin - User Details
	 * @returns Boolean - True if User get Login otherwise false.
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
