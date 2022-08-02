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
public class WishlistServiceImpl implements WishlistService{
@Autowired
WishlistRepository wishlistRepository;
@Autowired
UserRepository userRepository;
@Autowired
BookRepository bookRepository;

@Override
public Wishlist createWishlist(Wishlist wishlist) throws WishlistException {
  Wishlist wishlistAdded=null;

	//try {
		
	wishlistAdded=this.wishlistRepository.save(wishlist);
	//}
	//catch(Exception e)
	//{
		//throw new WishlistException("cant able to create wishlist");
	//}
	return wishlistAdded;
}
	
	


@Override
public Wishlist getWishlistById(Integer wishlistId) throws WishlistException {
	Optional<Wishlist> foundWishlist=this.wishlistRepository.findById(wishlistId);
	if(foundWishlist.isEmpty())
	{
		throw new WishlistException("Wishlist does not exist");
	}
	return foundWishlist.get();
}

@Override
public Wishlist updateWishlist(Wishlist wishlist) throws WishlistException {
	
		Optional<Wishlist> foundWishlist = this.wishlistRepository.findById(wishlist.getWishlistId());
		
	 if(foundWishlist.isEmpty()) {
			throw new WishlistException("Wishlist does not exists for id "+wishlist.getWishlistId());
		}
		return this.wishlistRepository.save(wishlist);
	
}

@Override
public String removeWishlistById(Integer wishlistId) throws WishlistException {
	String isDeleted="Unsuccessfull";
  Optional<Wishlist> foundWishlist=this.wishlistRepository.findById(wishlistId);
  if(!foundWishlist.isEmpty())
  {
	  this.wishlistRepository.deleteById(wishlistId);
	 isDeleted="successfully Deleted";
  }
  else
  {
	  throw new WishlistException("wishlist does not exist");
  }
return isDeleted;
	
}

@Override
public List<Wishlist> getAllWishlist() {

	return this.wishlistRepository.findAll();
}
}