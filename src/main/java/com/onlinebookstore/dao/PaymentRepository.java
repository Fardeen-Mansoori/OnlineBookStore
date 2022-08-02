package com.onlinebookstore.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onlinebookstore.dto.Payment;
@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {

	
}
