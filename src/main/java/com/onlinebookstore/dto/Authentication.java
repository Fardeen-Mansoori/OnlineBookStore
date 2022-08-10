package com.onlinebookstore.dto;

import javax.persistence.Entity;
import javax.persistence.Id;


public class Authentication {
	
	Integer id;
	String password;
	public Authentication() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Authentication(Integer id, String password) {
		super();
		this.id = id;
		this.password = password;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Authentication [id=" + id + ", password=" + password + "]";
	}
	
	
}
