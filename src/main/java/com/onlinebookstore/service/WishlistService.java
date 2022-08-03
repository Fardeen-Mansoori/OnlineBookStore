package com.onlinebookstore.service;

import java.util.List;

import com.onlinebookstore.dto.Wishlist;
import com.onlinebookstore.exception.WishlistException;

public interface WishlistService {

	Wishlist createWishlist(Wishlist wishlist) throws WishlistException;
	Wishlist getWishlistById(Integer wishlistId) throws WishlistException;
	Wishlist updateWishlist(Wishlist wishlist) throws WishlistException;
	String removeWishlistById(Integer wishlistId) throws WishlistException;
	List<Wishlist> getAllWishlist() throws WishlistException;
	
	
}