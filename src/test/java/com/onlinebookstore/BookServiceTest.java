package com.onlinebookstore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Test;
import com.onlinebookstore.dto.Book;
import com.onlinebookstore.dto.Category;
import com.onlinebookstore.exception.BookException;
import com.onlinebookstore.exception.OrderException;
import com.onlinebookstore.service.BookService;
import com.onlinebookstore.service.BookServiceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.AfterEach;

@SpringBootTest
public class BookServiceTest {
	
	//Autowired
	BookService  bookService = new BookServiceImpl();
	
	//Book book = new Book(55,"abc","abcd","fardeen",100.0, new Category(100,"abcd","abc"));
	
      Book book = new Book(51,null,null,null,null,new Category(100,"abcd","abc"));
	
	@Test
	public void addBookTest() throws BookException{
		
		assertNotNull(this.bookService.addBook(book));
	}
	
	@AfterEach
	public void deleteBookByIdTest() throws BookException{
		
		assertEquals("Successful", this.bookService.deleteBookById(book.getBookId()));
		
		assertEquals("Unsuccessful", this.bookService.deleteBookById(501));
		
	}

}
