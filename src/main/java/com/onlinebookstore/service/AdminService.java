package com.onlinebookstore.service;

import java.util.List;


import com.onlinebookstore.dto.Admin;
import com.onlinebookstore.exception.AdminException;
public interface AdminService {
	String registerAdmin(Admin admin) throws AdminException;
	List<Admin> getAdmin() throws AdminException;
	String updateAdmin(Admin admin) throws AdminException;
	String deleteAdmin(Integer adminId,String adminPassword) throws AdminException;
	Boolean login(Integer adminId,String adminPassword) throws AdminException;
	String changePassword(Integer id,String oldPassword, String newPassword) throws AdminException;
	}
