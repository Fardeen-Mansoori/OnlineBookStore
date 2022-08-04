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

@Service
public class WishlistServiceImpl implements WishlistService {
	@Autowired
	WishlistRepository wishlistRepository;
	@Autowired
	UserRepository userRepository;
	@Autowired
	BookRepository bookRepository;

	@Override
	public Wishlist createWishlist(Wishlist wishlist) throws WishlistException {
		if (wishlist == null) {
			throw new WishlistException("Wishlist cannot be null!");
		}
		Wishlist wishlistAdded;

		try {

			wishlistAdded = this.wishlistRepository.save(wishlist);
		} catch (Exception e) {
			throw new WishlistException("Wishlist could not be created");
		}
		return wishlistAdded;
	}

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

	@Override
	public String removeWishlistById(Integer wishlistId) throws WishlistException {
		if(wishlistId == null) {
			throw new WishlistException("Wishlist cannot be null");
		}
		String isDeleted;
		Optional<Wishlist> foundWishlist = this.wishlistRepository.findById(wishlistId);
		if (!foundWishlist.isEmpty()) {
			this.wishlistRepository.deleteById(wishlistId);
			isDeleted = "Successful";
		} else {
			throw new WishlistException("wishlist does not exist");
		}
		return isDeleted;

	}

	@Override
	public List<Wishlist> getAllWishlist() throws WishlistException {
		List<Wishlist> wishlistList = this.wishlistRepository.findAll();
		if (wishlistList.isEmpty()) {
			throw new WishlistException("No Wishlist Found!");
		}

		return wishlistList;
	}
}