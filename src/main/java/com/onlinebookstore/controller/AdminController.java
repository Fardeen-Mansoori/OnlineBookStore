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

import com.onlinebookstore.dto.Admin;

import com.onlinebookstore.exception.AdminException;

import com.onlinebookstore.service.AdminService;

@RestController
public class AdminController {
	@Autowired
	AdminService adminService;

<<<<<<< HEAD
	@PostMapping("admin")
	public Admin registerAdmin(@RequestBody Admin admin) throws AdminException {
=======
	@PostMapping("admin/add")
	public Admin registerUser(@RequestBody Admin admin) throws AdminException {
>>>>>>> 3236658ae43852ca0123dc9cc71dfcccf1ab6084

		return this.adminService.registerAdmin(admin);

	}

<<<<<<< HEAD
	@GetMapping("admins")
=======
	@GetMapping("admin/get")
>>>>>>> 3236658ae43852ca0123dc9cc71dfcccf1ab6084
	public List<Admin> getAdmin() throws AdminException {
		return this.adminService.getAdmin();

	}

	@PutMapping("admin/update")
	public Admin updateAdmin(@RequestBody Admin admin) throws AdminException {
		return this.adminService.updateAdmin(admin);

	}

	@DeleteMapping("admin/delete/{adminId}/{adminPassword}")
	public String deleteAdmin(@PathVariable Integer adminId, @PathVariable String adminPassword) throws AdminException {
		return this.adminService.deleteAdmin(adminId, adminPassword);

	}
}
