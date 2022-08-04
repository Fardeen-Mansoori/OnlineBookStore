package com.onlinebookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.onlinebookstore.dto.User;
import com.onlinebookstore.exception.UserException;
import com.onlinebookstore.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	UserService userService;
	
	@PostMapping("user/register")
	public User registerUser(@RequestBody User user) throws UserException {
		
			return this.userService.registerUser(user);
		
		
	}

	@GetMapping("user/get/{userId}")
	public User getUser(@PathVariable Integer userId) throws UserException {
		return this.userService.getUserById(userId);

	}

	@PutMapping("user/update")
	public User updateUser(@RequestBody User user) throws UserException {
		return this.userService.updateUser(user);
		
	}

	@DeleteMapping("user/delete/{userId}")
	public String deleteUserById(@PathVariable Integer userId) throws UserException {
		return this.userService.deleteUserById(userId);
		
	}

	@GetMapping("user/users")
	public List<User> getAllUsers() throws UserException{
		return this.userService.getAllUser();
	}

}
