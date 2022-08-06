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
import com.onlinebookstore.dto.Wishlist;
import com.onlinebookstore.exception.WishlistException;
import com.onlinebookstore.service.WishlistService;

@RestController
public class WishlistController {

	@Autowired
	WishlistService wishlistService;

	@GetMapping("wishlist/{wishlistId}")
	public Wishlist getWishlistById(@PathVariable Integer wishlistId) throws WishlistException {
		return this.wishlistService.getWishlistById(wishlistId);
	}

	@PostMapping("wishlist")
	public Wishlist createWishlist(@RequestBody Wishlist wishlist) throws WishlistException {
		Wishlist creationOfWishlist = null;
		try {
			creationOfWishlist = this.wishlistService.createWishlist(wishlist);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return creationOfWishlist;

	}

	@PutMapping("wishlist")
	public Wishlist updateWishlist(@RequestBody Wishlist wishlist) throws WishlistException {
		return this.wishlistService.updateWishlist(wishlist);
	}

	@DeleteMapping("wishlist/{wishlistId}")
	public String deleteWishlist(@PathVariable Integer wishlistId) throws WishlistException {
		return this.wishlistService.removeWishlistById(wishlistId);
	}

	@GetMapping("wishlist/wishlists")
	public List<Wishlist> getAllWishlists() throws WishlistException {
		return this.wishlistService.getAllWishlist();
	}

}