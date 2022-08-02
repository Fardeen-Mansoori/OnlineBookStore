package com.onlinebookstore.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onlinebookstore.dto.User;
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
