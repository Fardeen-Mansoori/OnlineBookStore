package com.onlinebookstore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.onlinebookstore.service.CartService;

@SpringBootTest
public class CartServiceTest {
	
	@Autowired
	CartService cartService;

}
