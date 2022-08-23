package com.onlinebookstore;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.onlinebookstore.dao.WishlistRepository;
import com.onlinebookstore.dto.User;
import com.onlinebookstore.dto.Wishlist;
import com.onlinebookstore.exception.WishlistException;
import com.onlinebookstore.service.WishlistService;

@SpringBootTest
public class WishlistServiceTest {
	
	@Autowired
	WishlistService wishlistService;
	
	@Autowired
	WishlistRepository wishlistRepository;
	
	
	
	Wishlist wishlist = new Wishlist(null,null,null);
	
	
	@Test
	public void getWishlistByIdTest() throws WishlistException{
		
		assertNotNull(this.wishlistService.getWishlistById(wishlist.getWishlistId()));
		assertThrows(WishlistException.class,()->this.wishlistService.getWishlistById(0));
		assertThrows(WishlistException.class,()->this.wishlistService.getWishlistById(null));
		
	}
	@Test
	public void updateWishlistTest() throws WishlistException{
		User user = new User(490, "Devesh", "12345678", "devesh@gmail.com", "Delhi,India", "1234567890", null); //this user must be in db then only this test method will work fine
		
		
		
		wishlist.setUser(user);
		assertNotNull(this.wishlistService.updateWishlist(wishlist));
		assertEquals(user,wishlist.getUser());
		
		assertThrows(WishlistException.class,()->this.wishlistService.updateWishlist(null));
		
	}

	@Test
	public void getAllWishlistTest() throws WishlistException {
		
		assertNotNull(this.wishlistService.getAllWishlist());
		this.wishlistRepository.deleteAll();
		assertThrows(WishlistException.class,()->this.wishlistService.getAllWishlist());
		
	}

	
}