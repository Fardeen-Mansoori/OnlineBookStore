package com.onlinebookstore.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.onlinebookstore.dto.Cart;
import com.onlinebookstore.dto.CartItem;
import com.onlinebookstore.dto.Order;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Integer> {
	
	List<CartItem> findByCart(Cart cart);

    List<CartItem> findByOrder(Order order);

}
