package com.onlinebookstore.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Admin {
	@Id
	private Integer adminId;
	private String adminPassword;

	public Admin() {
		super();
	}

	public Admin(Integer adminId) {
		super();
		this.adminId = adminId;
		// TODO Auto-generated constructor stub
	}

	public Admin(Integer adminId, String adminPassword) {
		super();
		this.adminId = adminId;
		this.adminPassword = adminPassword;

	}

	public Integer getAdminId() {
		return adminId;
	}

	public void setAdminId(Integer adminId) {
		this.adminId = adminId;

	}

	public String getAdminPassword() {
		return adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + "]";
	}

}
