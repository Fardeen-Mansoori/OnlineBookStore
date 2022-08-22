package com.onlinebookstore.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.onlinebookstore.dao.BookRepository;
import com.onlinebookstore.dto.Book;
import com.onlinebookstore.exception.BookException;

@Service
//Repository
public class BookServiceImpl implements BookService {
	@Autowired
	BookRepository bookRepository;

//@Transactional
	@Override
	public Book addBook(Book book) throws BookException {
		Book bookAdded = null;
		try {
			bookAdded = this.bookRepository.save(book);
		} catch (Exception e) {
			throw new BookException("Book could not be Added");
		}
		return bookAdded;

	}

	@Transactional
	@Override
	public Book getBookById(Integer bookId) throws BookException {
		Optional<Book> optBook = bookRepository.findById(bookId);

		if (optBook.isEmpty()) {
			throw new BookException("Book doesn't exist for bookid " + bookId);
		}
		return optBook.get();
	}

	@Override
	@Transactional
	public Book updateBook(Book book) throws BookException {
		if(book==null) {
			throw new BookException("Book cannot be null");
		}
		Optional<Book> foundBook = this.bookRepository.findById(book.getBookId());

		if (foundBook.isEmpty()) {
			throw new BookException("Book doesnot exists for id " + book.getBookId());
		}
		return this.bookRepository.save(book);
	}

	@Override
	@Transactional
	public String deleteBookById(Integer bookId) throws BookException {

		String isDeleted;
		Optional<Book> foundBook = bookRepository.findById(bookId);
		if (foundBook.isEmpty()) {
			throw new BookException("Book does not exist for id " + bookId);
		} else {
			bookRepository.delete(foundBook.get());
			isDeleted = "Successful";
		}
		return isDeleted;

	}

	@Override
	public List<Book> getAllBooks() throws BookException {
        List<Book> bookList = this.bookRepository.findAll();
        if(bookList.isEmpty()) {
        	throw new BookException("No books found");
        }
		return bookList;
	}

	

	@Override
	public List<Book> findByBookName(String bookName) throws BookException {
		List<Book> bookList = bookRepository.findByBookName(bookName);
		if(bookList.isEmpty()) {
			throw new BookException("No books found");
		}
		return bookList;
	}

	
}
