package com.onlinebookstore.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onlinebookstore.dto.Book;
@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

}
