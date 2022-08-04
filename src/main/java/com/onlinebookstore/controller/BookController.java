package com.onlinebookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.onlinebookstore.dto.Book;
import com.onlinebookstore.exception.BookException;
import com.onlinebookstore.service.BookService;

@RestController
public class BookController {
@Autowired
BookService bookService;

@PostMapping("book/add")
public Book addBook(@RequestBody Book book) {
	 Book foundBook=null;
	try {
		foundBook=this.bookService.addBook(book);
	} catch (BookException e) {
		System.out.println(e.getMessage());
	}
	return foundBook;
	
}

@GetMapping("book/{bookId}")
public Book getBook(@PathVariable Integer bookId) throws BookException {
	return this.bookService.getBookById(bookId);

}

@PutMapping("book/update")
public Book updateBook(@RequestBody Book book) throws BookException {
	return this.bookService.updateBook(book);
	
}


@DeleteMapping("book/delete/{bookId}")
public String deleteBookById(@PathVariable Integer bookId) throws BookException {
	return this.bookService.deleteBookById(bookId);
	
}

@GetMapping("book/allBooks")
public List<Book> getAllBooks() throws BookException{
	return this.bookService.getAllBooks();
}
	
}
