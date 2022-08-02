package com.onlinebookstore.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onlinebookstore.dto.CardDetails;
@Repository
public interface CardRepository extends JpaRepository<CardDetails, Integer>{

}
