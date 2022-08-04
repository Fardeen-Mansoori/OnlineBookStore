package com.onlinebookstore.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinebookstore.dao.UserPaymentRepository;

import com.onlinebookstore.dto.UserPayment;
import com.onlinebookstore.exception.PaymentException;

@Service
public class UserPaymentServiceImpl {

	@Autowired
	private UserPaymentRepository userPaymentRepository;

	public UserPayment findById(Long id) throws PaymentException {
		Optional<UserPayment> foundPayment = userPaymentRepository.findById(id);
		if (foundPayment.isEmpty()) {
			throw new PaymentException("User Payment doesnot exists for id" + id);
		}

		return foundPayment.get();
	}

	public void removeById(Long id) {
		userPaymentRepository.deleteById(id);
	}

}
