package com.onlinebookstore;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.onlinebookstore.dto.Wishlist;
import com.onlinebookstore.exception.WishlistException;
import com.onlinebookstore.service.WishlistService;

@SpringBootTest
public class WishlistTest {

	@Autowired
	WishlistService wishlistService;

	Wishlist wishlist = new Wishlist(0, null, null, null);

	@Test
	public void createWishlistTest() throws WishlistException {

		assertNotNull(wishlistService.createWishlist(wishlist));
		// assertThrows(WishlistException.class, () ->
		// wishlistService.getWishlistById(wishlist.getWishlistId()));

	}

	@Test
	public void getWishlistByIdTest() throws WishlistException {
		assertNotNull(wishlistService.getWishlistById(wishlist.getWishlistId()));

	}

	@Test
	public void updateWishlistTest() throws WishlistException {

		assertNotNull(wishlistService.updateWishlist(wishlist));

	}

	@AfterEach
	@Test
	public void deleteWishlisByIdtTest() throws WishlistException {
		assertEquals("successfully Deleted", this.wishlistService.removeWishlistById(wishlist.getWishlistId()));
		// assertThrows(WishlistException.class,()->wishlistService.removeWishlistById(100));

	}

}
