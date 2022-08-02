package com.onlinebookstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinebookstore.dao.CardRepository;

@Service
public class CardServiceImpl implements CardService{
@Autowired
	CardRepository cardRepository;
}
