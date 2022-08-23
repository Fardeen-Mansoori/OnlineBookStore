package com.onlinebookstore.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.onlinebookstore.dao.BookRepository;
import com.onlinebookstore.dto.Book;
import com.onlinebookstore.exception.BookException;


/************************************************************************************
 * @author Kewal Shah
 * @Description It is a service class that provides the services for adding a
 *              new book, get book by ID, Update book, Get all books and get all
 *              book by name.
 * Version 1.0 
 * Created Date 10-AUG-2022
 ************************************************************************************/
@Service
//Repository
public class BookServiceImpl implements BookService {
	@Autowired
	BookRepository bookRepository;

	/************************************************************************************
	 * Method: - addBook() Description: - Adding book in the Book Store Application.
	 * @object Book - Book details
	 * @returns the saved entity, if book added otherwise throws BookException
	 * @throws BookException - It is raised due to book details are invalid or null
	 ************************************************************************************/
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

	/************************************************************************************
	 * Method: - getBookByID()
	 * @Description: - Get Book by ID from the Book Store Application.
	 * @parameter bookId - Book ID
	 * @returns the saved entity i.e. book if book exists otherwise throws
	 *          BookException
	 * @throws BookException - It is raised due to book details are invalid, or book
	 *                       id is not present.
	 ************************************************************************************/
	@Transactional
	@Override
	public Book getBookById(Integer bookId) throws BookException {
		Optional<Book> optBook = bookRepository.findById(bookId);

		if (optBook.isEmpty()) {
			throw new BookException("Book doesn't exist for bookid " + bookId);
		}
		return optBook.get();
	}

	/************************************************************************************
	 * Method: - updateBook()
	 * @Description: - Update the book in the Book Store Application.
	 * @object Book - Book detail
	 * @returns the updated entity i.e. Book if Book exists otherwise throws
	 *          BookException
	 * @throws BookException - It is raised due to Book details are invalid, or Book
	 *                       id is not present.
	 ************************************************************************************/

	@Override
	@Transactional
	public Book updateBook(Book book) throws BookException {
		if (book == null) {
			throw new BookException("Book cannot be null");
		}
		Optional<Book> foundBook = this.bookRepository.findById(book.getBookId());

		if (foundBook.isEmpty()) {
			throw new BookException("Book doesnot exists for id " + book.getBookId());
		}
		return this.bookRepository.save(book);
	}

	/************************************************************************************
	 * Method: - deleteBookById()
	 * @Description: - Delete the exists Book in the Book Store Application.
	 * @parameter bookId
	 * @returns String - Successful, if book deleted successfully otherwise throws
	 *          BookException
	 * @throws BookException - It is raised due to Book details are invalid, or book
	 *                       id is not present.
	 ************************************************************************************/
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

	/************************************************************************************
	 * Method: - getAllBooks()
	 * 
	 * @Description: - retrieve all the books in the Book Store Application.
	 * @returns List<Book> - List of books if exists otherwise throws BookException
	 * @throws BookException - It is raised when there is no book found.
	 ************************************************************************************/
	@Override
	public List<Book> getAllBooks() throws BookException {
		List<Book> bookList = this.bookRepository.findAll();
		if (bookList.isEmpty()) {
			throw new BookException("No books found");
		}
		return bookList;
	}

	/************************************************************************************
	 * Method: - findByBookName()
	 * @Description: - retrieve the books by name in the Book Store Application.
	 * @returns List<Book> - List of books if exists otherwise throws BookException
	 * @throws BookException - It is raised when there is no book found.
	 ************************************************************************************/

	@Override
	public List<Book> findByBookName(String bookName) throws BookException {
		List<Book> bookList = bookRepository.findByBookName(bookName);
		if (bookList.isEmpty()) {
			throw new BookException("No books found");
		}
		return bookList;
	}

}
