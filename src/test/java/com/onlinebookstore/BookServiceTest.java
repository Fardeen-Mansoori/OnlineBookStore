package com.onlinebookstore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Test;

import com.onlinebookstore.dao.BookRepository;
import com.onlinebookstore.dto.Book;
import com.onlinebookstore.dto.Category;
import com.onlinebookstore.exception.BookException;
import com.onlinebookstore.exception.OrderException;
import com.onlinebookstore.service.BookService;
import com.onlinebookstore.service.BookServiceImpl;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;


import org.junit.jupiter.api.AfterEach;

@SpringBootTest
public class BookServiceTest {
	
	@Autowired
	private BookService  bookService;
	
	@Autowired
	BookRepository bookRepository;
	
	//Book book = new Book(55,"abc","abcd","fardeen",100.0, new Category(100,"abcd","abc"));
	
      Book book = new Book(51,null,null,null,null,new Category(100,"abcd","abc"));
	
	@Test
	public void addBookTest() throws BookException{
		
		assertNotNull(this.bookService.addBook(book));
		assertThrows(BookException.class,()->this.bookService.addBook(null));
	}
	
	@Test
	public void getBookByIdTest() throws BookException{
		
		assertNotNull(this.bookService.addBook(book));
		assertNotNull(this.bookService.getBookById(book.getBookId()));
		assertThrows(BookException.class,()->this.bookService.getBookById(0));
		
	}
	
	@Test
	public void updateBookTest() throws BookException{
		
		assertNotNull(this.bookService.addBook(book));
		book.setBookName("New Book");
		assertEquals("New Book",book.getBookName());
		assertThrows(BookException.class,()->this.bookService.updateBook(null));
		
	}
	
	
	@Test
	public void deleteBookByIdTest() throws BookException{
		
		assertNotNull(this.bookService.addBook(book));
		
		assertEquals("Successful", this.bookService.deleteBookById(book.getBookId()));
		
		assertThrows(BookException.class,()-> this.bookService.deleteBookById(0));
		
		
	}
	
	@Test
	public void getAllBooksTest() throws BookException{
		
		assertNotNull(this.bookService.addBook(book));
		assertNotNull(this.bookService.getAllBooks());
		this.bookRepository.deleteAll();
		assertThrows(BookException.class,()->this.bookService.getAllBooks());
	}
	
	

}
