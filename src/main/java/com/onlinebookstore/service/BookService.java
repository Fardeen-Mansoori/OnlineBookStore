package com.onlinebookstore.service;

import com.onlinebookstore.dto.Book;
import com.onlinebookstore.exception.BookException;
import java.util.List;
import java.util.Optional;

public interface BookService {

	Book addBook(Book book) throws BookException;
	Book getBookById(Integer bookId) throws BookException;
	Book updateBook(Book book) throws BookException;
	String deleteBookById(Integer bookId) throws BookException;
	List<Book> getAllBooks() throws BookException;
	
}
