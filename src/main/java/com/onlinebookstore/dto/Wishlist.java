package com.onlinebookstore.dto;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Wishlist {
	@Id
	private Integer wishlistId;

	@OneToOne
	private User user;

	@OneToMany
	private List<Book> book;

	private Date dateOfCreation;

	public Wishlist() {
		super();

	}

	public Integer getWishlistId() {
		return wishlistId;
	}

	public void setWishlistId(Integer wishlistId) {
		this.wishlistId = wishlistId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Book> getBook() {
		return book;
	}

	public void setBook(List<Book> book) {
		this.book = book;
	}

	public Date getDateOfCreation() {
		return dateOfCreation;
	}

	public void setDateOfCreation(Date dateOfCreation) {
		this.dateOfCreation = dateOfCreation;
	}

	public Wishlist(Integer wishlistId, User user, List<Book> book, Date dateOfCreation) {
		super();
		this.wishlistId = wishlistId;
		this.user = user;
		this.book = book;
		this.dateOfCreation = dateOfCreation;
	}

	@Override
	public String toString() {
		return "Wishlist [wishlistId=" + wishlistId + ", user=" + user + ", book=" + book + ", dateOfCreation="
				+ dateOfCreation + "]";
	}

	
}