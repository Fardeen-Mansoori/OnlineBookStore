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

/************************************************************************************
 * @author Devesh Chitlangia
 * @Description It is a service class that provides the services for creating a
 *              new user, get user by ID, Update User and Get All Users. Version
 *              1.0 Created Date 16-AUG-2022
 ************************************************************************************/
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepository userRepository;
	@Autowired
	CartRepository cartRepository;
	@Autowired
	WishlistRepository wishlistRepository;

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
		cart.setCartTotal(0.0);
		wishlist.setUser(user);
		user.setCart(cart);
		user.setWishlist(wishlist);

		return this.userRepository.save(user);
	}

	/************************************************************************************
	 * Method: - Get User By ID 
	 * @Description: - Get Registered User by ID from the
	 * Book Store Application.
	 * 
	 * @parameter userId - User ID
	 * @returns the saved entity i.e. User if User exists otherwise throws User
	 *          Exception
	 * @throws UserException - It is raised due to User details are invalid, or User
	 *                       id is not present.
	 ************************************************************************************/

	@Override
	public User getUserById(Integer userId) throws UserException {
		// TODO Auto-generated method stub
		Optional<User> foundUser = this.userRepository.findById(userId);
		if (foundUser.isEmpty()) {
			throw new UserException("User doesnot exists for id " + userId);
		}
		return foundUser.get();
	}

	/************************************************************************************
	 * Method: - Update User 
	 * @Description: - Update the Registered User in the Book Store
	 * Application.
	 * 
	 * @object User - User detail
	 * @returns  the updated entity i.e. User if User exists otherwise throws User
	 *          Exception
	 * @throws UserException - It is raised due to User details are invalid, or User
	 *                       id is not present.
	 ************************************************************************************/

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

	/************************************************************************************
	 * Method: - Delete User by Id
	 * @Description: - Delete the exists User in the Book Store
	 * Application.
	 * 
	 * @parameter UserId - User ID
	 * @returns String - Successful, if user deleted successfully otherwise throws User
	 *          Exception
	 * @throws UserException - It is raised due to User details are invalid, or User
	 *                       id is not present.
	 ************************************************************************************/

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

	/************************************************************************************
	 * Method: - get All registered users
	 * @Description: - retrieve all registered User in the Book Store
	 * Application.
	 * @returns List<User> - List of registered users if exists otherwise throws User
	 *          Exception
	 * @throws UserException - It is raised when there is no users found.
	 ************************************************************************************/

	@Override
	public List<User> getAllUser() throws UserException {
		// TODO Auto-generated method stub
		List<User> userList = this.userRepository.findAll();
		if (userList.isEmpty()) {
			throw new UserException("No Users Found!");
		}
		return userList;
	}

	/************************************************************************************
	 * Method: - Login
	 * @Description: - Registered User in the Book Store
	 * Application.
	 * 
	 * @parameter userId, userPassword - User ID and User Password
	 * @returns Boolean - true, if customer registered otherwise throws User
	 *          Exception
	 * @throws UserException - It is raised due to User password are invalid, or User
	 *                       id is not present.
	 ************************************************************************************/

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
