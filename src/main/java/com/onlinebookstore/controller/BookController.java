package com.onlinebookstore.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.MethodArgumentNotValidException;
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

	@PostMapping("book")
	public Book addBook(@Valid @RequestBody Book book) throws BookException, MethodArgumentNotValidException {
		return this.bookService.addBook(book);

	}

	@GetMapping("book/{bookId}")
	public Book getBook(@PathVariable Integer bookId) throws BookException {
		return this.bookService.getBookById(bookId);

	}

	@PutMapping("book")
	public Book updateBook(@Valid @RequestBody Book book) throws BookException, MethodArgumentNotValidException {
		return this.bookService.updateBook(book);

	}

	@DeleteMapping("book/{bookId}")
	public String deleteBookById(@PathVariable Integer bookId) throws BookException {
		return this.bookService.deleteBookById(bookId);

	}

	@GetMapping("books")
	public List<Book> getAllBooks() throws BookException {
		return this.bookService.getAllBooks();
	}

}
