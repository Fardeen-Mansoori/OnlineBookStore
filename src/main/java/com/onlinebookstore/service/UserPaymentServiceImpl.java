package com.onlinebookstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinebookstore.dao.UserPaymentRepository;
import com.onlinebookstore.dto.UserPayment;

@Service
public class UserPaymentServiceImpl {
	
	@Autowired
    private UserPaymentRepository userPaymentRepository;

    public UserPayment findById(Long id) {
        return userPaymentRepository.findById(id).get();
    }

    public void removeById(Long id) {
        userPaymentRepository.deleteById(id);
    }

}
