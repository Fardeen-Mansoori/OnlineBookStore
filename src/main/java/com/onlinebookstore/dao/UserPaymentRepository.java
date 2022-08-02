package com.onlinebookstore.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onlinebookstore.dto.UserPayment;
@Repository
public interface UserPaymentRepository extends JpaRepository<UserPayment, Long>{

}
