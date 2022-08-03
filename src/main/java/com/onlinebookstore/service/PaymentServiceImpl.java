package com.onlinebookstore.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinebookstore.dao.PaymentRepository;
import com.onlinebookstore.dto.Payment;
import com.onlinebookstore.dto.UserPayment;
import com.onlinebookstore.exception.PaymentException;

@Service
public class PaymentServiceImpl implements PaymentService {
	@Autowired
	PaymentRepository paymentRepository;

	@Override
	public Payment setByUserPayment(UserPayment userPayment, Payment payment) throws PaymentException {
		payment.setType(userPayment.getType());
		payment.setHolderName(userPayment.getHolderName());
		payment.setCardName(userPayment.getCardName());
		payment.setExpiryMonth(userPayment.getExpiryMonth());
		payment.setExpiryYear(userPayment.getExpiryYear());
		payment.setCvc(userPayment.getCvc());
		payment.setCardNumber(userPayment.getCardNumber());

		return payment;

	}

	@Override
	public Payment createPayment(Payment payment) throws PaymentException {

		return paymentRepository.save(payment);
	}

	@Override
	public Payment getPaymentById(Integer paymentId) throws PaymentException {
		Optional<Payment> foundPayment = paymentRepository.findById(paymentId);

		if (foundPayment.isEmpty()) {
			throw new PaymentException("Payment doesn't exists for Id :" + paymentId);

		}

		return foundPayment.get();
	}
}
