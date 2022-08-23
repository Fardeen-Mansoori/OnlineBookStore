package com.onlinebookstore.dto;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
public class Book {
	@Id
	private Integer bookId;
	@NotNull(message="Name cannot be null")
	@NotBlank()
	private String bookName;
	@NotNull(message="BookDescription cannot be null")
	@NotBlank()
	private String bookDescription;
	@NotNull(message="AuthorName cannot be null")
	@NotBlank()
	private String bookAuthor;
	@NotNull(message="Price cannot be null")
	//@NotBlank()
	@Min(value=10, message="Min price can be 10")
	private Double bookPrice;

	
	@ManyToOne
	//@JoinColumn(name="category_id")
	//@JsonIgnore
	private Category category;
	
	
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Book(Integer bookId, String bookName, String bookDescription, String bookAuthor, Double bookPrice,
			Category category) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.bookDescription = bookDescription;
		this.bookAuthor = bookAuthor;
		this.bookPrice = bookPrice;
		this.category = category;
	}

	public Integer getBookId() {
		return bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getBookDescription() {
		return bookDescription;
	}

	public void setBookDescription(String bookDescription) {
		this.bookDescription = bookDescription;
	}

	public String getBookAuthor() {
		return bookAuthor;
	}

	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

	public Double getBookPrice() {
		return bookPrice;
	}

	public void setBookPrice(Double bookPrice) {
		this.bookPrice = bookPrice;
	}
	
	public Category getCategory() {
		return category;
	}
	
	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", bookName=" + bookName + ", bookDescription=" + bookDescription
				+ ", bookAuthor=" + bookAuthor + ", bookPrice=" + bookPrice + ", category=" + category + "]";
	}}
	