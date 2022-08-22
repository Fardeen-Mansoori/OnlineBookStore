package com.onlinebookstore.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.onlinebookstore.dto.BookToCartItem;
import com.onlinebookstore.dto.CartItem;

@Repository
public interface BookToCartItemRepository extends JpaRepository<BookToCartItem, Integer> {
	void deleteByCartItem(CartItem cartItem);

}
