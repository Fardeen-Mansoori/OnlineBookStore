package com.onlinebookstore.service;

import com.onlinebookstore.dto.UserPayment;

public interface UserPaymentService {
	
	UserPayment findById(Long id);

    void removeById(Long id);

}
