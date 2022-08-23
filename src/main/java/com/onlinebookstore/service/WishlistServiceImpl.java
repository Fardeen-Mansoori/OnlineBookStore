package com.onlinebookstore.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.onlinebookstore.dao.BookRepository;
import com.onlinebookstore.dao.UserRepository;
import com.onlinebookstore.dao.WishlistRepository;
import com.onlinebookstore.dto.Wishlist;
import com.onlinebookstore.exception.WishlistException;

/************************************************************************************
 * @author Kewal Shah Description It is a service implementation class that
 *         provides the services for getting wishlist ,updating wishlist and
 *         getting all wishlists. Version 1.0 Created Date 10/08/2022
 ************************************************************************************/
@Service
public class WishlistServiceImpl implements WishlistService {
	@Autowired
	WishlistRepository wishlistRepository;
	@Autowired
	UserRepository userRepository;
	@Autowired
	BookRepository bookRepository;

	/************************************************************************************
	 * Method: getWishlistById() Description: To get the wishlist by id
	 * 
	 * @param wishlistId
	 *
	 * @returns Wishlist- It returns wishlist object, if any error occurs it will
	 *          throw WishlistException
	 * @throws WishlistException - It is raised due to invalid wishlistId By - Kewal
	 *                           Shah Created Date - 10-Aug-2022
	 * 
	 ************************************************************************************/
	@Override
	public Wishlist getWishlistById(Integer wishlistId) throws WishlistException {
		if (wishlistId == null) {
			throw new WishlistException("Wishlist cannot be null");
		}
		Optional<Wishlist> foundWishlist = this.wishlistRepository.findById(wishlistId);
		if (foundWishlist.isEmpty()) {
			throw new WishlistException("Wishlist does not exist");
		}
		return foundWishlist.get();
	}

	/************************************************************************************
	 * Method: updateWishlist() Description: To update the wishlist
	 * 
	 * @param wishlist
	 *
	 * @returns Wishlist- It returns wishlist object, if any error occurs it will
	 *          throw WishlistException
	 * @throws WishlistException - It is raised due to invalid wishlistId By - Kewal
	 *                           Shah Created Date - 10-Aug-2022
	 * 
	 ************************************************************************************/
	@Override
	public Wishlist updateWishlist(Wishlist wishlist) throws WishlistException {
		if (wishlist == null) {
			throw new WishlistException("Wishlist cannot be null");
		}

		Optional<Wishlist> foundWishlist = this.wishlistRepository.findById(wishlist.getWishlistId());

		if (foundWishlist.isEmpty()) {
			throw new WishlistException("Wishlist does not exists for id " + wishlist.getWishlistId());
		}
		return this.wishlistRepository.save(wishlist);

	}

	/************************************************************************************
	 * Method: getAllWishlist() Description: To get all the wishlists
	 * 
	 * @returns WishlistList- It will returns wishlistList, if any error occurs it
	 *          will throw WishlistException
	 * @throws WishlistException - If wishlist will be empty it throws no wishlist
	 *                           found message
	 * 
	 *                           By - Kewal Shah Created Date - 10-Aug-2022
	 * 
	 ************************************************************************************/
	@Override
	public List<Wishlist> getAllWishlist() throws WishlistException {
		List<Wishlist> wishlistList = this.wishlistRepository.findAll();
		if (wishlistList.isEmpty()) {
			throw new WishlistException("No Wishlist Found!");
		}

		return wishlistList;
	}
}