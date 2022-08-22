package com.onlinebookstore.service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinebookstore.dao.CartRepository;
import com.onlinebookstore.dao.UserRepository;
import com.onlinebookstore.dao.WishlistRepository;
import com.onlinebookstore.dto.Cart;
import com.onlinebookstore.dto.User;
import com.onlinebookstore.dto.Wishlist;
import com.onlinebookstore.exception.UserException;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepository userRepository;
	@Autowired
	CartRepository cartRepository;
	@Autowired
	WishlistRepository wishlistRepository;

	@Override
	public User registerUser(User user) throws UserException {
		// TODO Auto-generated method stub
		if (user == null) {
			throw new UserException("User cannot be Null!");
		}
		Optional<User> foundUser = this.userRepository.findById(user.getUserId());
		if (!(foundUser.isEmpty())) {
			throw new UserException("User already exists!");
		}
		Cart cart = new Cart();
		Wishlist wishlist = new Wishlist();
		cart.setUser(user);
		wishlist.setUser(user);
		user.setCart(cart);
		user.setWishlist(wishlist);

		return this.userRepository.save(user);
	}

	@Override
	public User getUserById(Integer userId) throws UserException {
		// TODO Auto-generated method stub
		Optional<User> foundUser = this.userRepository.findById(userId);
		if (foundUser.isEmpty()) {
			throw new UserException("User doesnot exists for id " + userId);
		}
		return foundUser.get();
	}

	@Override
	public User updateUser(User user) throws UserException {
		// TODO Auto-generated method stub
		if (user == null) {
			throw new UserException("User cannot be Null!");
		}
		Optional<User> foundUser = this.userRepository.findById(user.getUserId());

		if (foundUser.isEmpty()) {
			throw new UserException("User doesnot exists for id " + user.getUserId());
		}
		return this.userRepository.save(user);

	}

	@Override
	public String deleteUserById(Integer userId) throws UserException {

		String isDeleted;
		Optional<User> foundUser = userRepository.findById(userId);
		if (foundUser.isEmpty()) {
			throw new UserException("User does not exist for id " + userId);
		} else {
			this.cartRepository.delete(new Cart(foundUser.get().getUserId(), foundUser.get()));
			this.wishlistRepository.delete(new Wishlist(foundUser.get().getUserId()));
			userRepository.delete(foundUser.get());
			isDeleted = "Successful";
		}
		return isDeleted;
	}

	@Override
	public List<User> getAllUser() throws UserException {
		// TODO Auto-generated method stub
		List<User> userList = this.userRepository.findAll();
		if (userList.isEmpty()) {
			throw new UserException("No Users Found!");
		}
		return userList;
	}

	@Override
	public Boolean login(Integer userId, String userPassword) throws UserException {
		boolean isLogedin = false;
		Optional<User> foundUser = this.userRepository.findById(userId);
		if (foundUser.isEmpty()) {
			throw new UserException("User doesnot exists for id " + userId);
		}
		if (!foundUser.get().getUserPassword().equals(userPassword)) {
			throw new UserException("Incorrect password");
		}
		if (foundUser.get().getUserPassword().equals(userPassword)) {
			isLogedin = true;
		}
		return isLogedin;
	}
}
