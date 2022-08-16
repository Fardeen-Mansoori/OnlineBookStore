package com.onlinebookstore.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinebookstore.dao.PaymentRepository;
import com.onlinebookstore.dto.Payment;

import com.onlinebookstore.exception.PaymentException;

@Service
public class PaymentServiceImpl implements PaymentService {
	@Autowired
	PaymentRepository paymentRepository;

	

	@Override
	public Payment createPayment(Payment payment) throws PaymentException {

		return paymentRepository.save(payment);
	}

	@Override
	public Payment getPaymentById(Integer paymentId) throws PaymentException {
		Optional<Payment> foundPayment = paymentRepository.findById(paymentId);

		if (foundPayment.isEmpty()) {
			throw new PaymentException("Payment doesn't exists for Id : " + paymentId);

		}

		return foundPayment.get();
	}
}
