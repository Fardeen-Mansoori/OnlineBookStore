package com.onlinebookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinebookstore.dao.CartRepository;
import com.onlinebookstore.dao.UserRepository;
import com.onlinebookstore.dto.Cart;
import com.onlinebookstore.dto.User;
import com.onlinebookstore.exception.UserException;

@Service
public class UserServiceImpl implements UserService{
@Autowired
UserRepository userRepository;
@Autowired
CartRepository cartRepository;

@Override
public User registerUser(User user) throws UserException {
	// TODO Auto-generated method stub
	Optional<User> foundUser = this.userRepository.findById(user.getUserId());
	if(!foundUser.isEmpty()) {
		throw new UserException("User already exists!");
	}
	this.cartRepository.save(new Cart(user.getUserId()));
	
	return userRepository.save(user);
}

@Override
public User getUserById(Integer userId) throws UserException {
	// TODO Auto-generated method stub
	Optional<User> foundUser = this.userRepository.findById(userId);
	if(foundUser.isEmpty()) {
		throw new UserException("User doesnot exists for id "+userId);
	}
	return foundUser.get();
}

@Override
public User updateUser(User user) throws UserException {
	// TODO Auto-generated method stub
	Optional<User> foundUser = this.userRepository.findById(user.getUserId());
	if(user.equals(null)) {
		throw new UserException("Enter valid User Details!");
	}else if(foundUser.isEmpty()) {
		throw new UserException("User doesnot exists for id "+user.getUserId());
	}
	return this.userRepository.save(user);
	
}

@Override
public String deleteUserById(Integer userId) throws UserException {
	
	String isDeleted = "Unsuccessful";
	Optional<User> foundUser = userRepository.findById(userId);
	if(foundUser.isEmpty()) {
		throw new UserException("User does not exist for id "+userId);
	}else {
		userRepository.delete(foundUser.get());
		this.cartRepository.delete(new Cart(foundUser.get().getUserId()));
		isDeleted = "Successful";
	}
	return isDeleted;
}

@Override
public List<User> getAllUser() throws UserException {
	// TODO Auto-generated method stub
	return this.userRepository.findAll();
}
}
