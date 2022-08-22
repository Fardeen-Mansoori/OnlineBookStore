package com.onlinebookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.onlinebookstore.dto.Book;
import com.onlinebookstore.exception.BookException;
import com.onlinebookstore.exception.CategoryException;
import com.onlinebookstore.service.BookService;
import com.onlinebookstore.service.CategoryService;

@RestController
public class SearchController {
	
	@Autowired
	private BookService bookService;
	
	@Autowired
	private CategoryService categoryService;

	@GetMapping("/searchByCategory/{category}")
	public List<Book> searchByCategory(@PathVariable String category) throws CategoryException {

		List<Book> bookList = categoryService.findBycategoryName(category);

		return bookList;
	}

	@GetMapping("/searchBook/{bookName}")
	public List<Book> searchbook(@PathVariable String bookName) throws BookException {

		List<Book> bookList = bookService.findByBookName(bookName);

		return bookList;
	}

}
