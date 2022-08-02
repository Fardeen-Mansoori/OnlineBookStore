package com.onlinebookstore.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.onlinebookstore.dto.Admin;
@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {

}
