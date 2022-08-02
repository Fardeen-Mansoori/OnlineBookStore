package com.onlinebookstore.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onlinebookstore.dto.Wishlist;

@Repository
public interface WishlistRepository extends JpaRepository<Wishlist, Integer> {

}
