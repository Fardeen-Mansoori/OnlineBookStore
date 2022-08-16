package com.onlinebookstore.service;

import java.util.List;


import com.onlinebookstore.dto.User;
import com.onlinebookstore.exception.UserException;

public interface UserService {
	
	User registerUser(User user) throws UserException;
	User getUserById(Integer userId) throws UserException;
	User updateUser(User user) throws UserException;
	String deleteUserById(Integer userId) throws UserException;
	List<User> getAllUser() throws UserException;
	Boolean login(Integer userId,String userPassword) throws UserException;
}
