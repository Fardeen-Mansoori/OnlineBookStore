package com.onlinebookstore.service;

import java.util.List;


import com.onlinebookstore.dto.Admin;
import com.onlinebookstore.exception.AdminException;
public interface AdminService {
	Admin registerAdmin(Admin admin) throws AdminException;
	List<Admin> getAdmin() throws AdminException;
	Admin updateAdmin(Admin admin) throws AdminException;
	String deleteAdmin(Integer adminId,String adminPassword) throws AdminException;
	Boolean login(Integer adminId,String adminPassword) throws AdminException;
	}
