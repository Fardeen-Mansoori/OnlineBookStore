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
import com.onlinebookstore.dto.User;
import com.onlinebookstore.exception.AdminException;
import com.onlinebookstore.exception.UserException;
import com.onlinebookstore.service.AdminService;
@RestController
public class AdminController {
	@Autowired
	AdminService adminService;
	
	@PostMapping("admin")
	public Admin registerUser(@RequestBody Admin admin) throws AdminException {
		
			return this.adminService.registerAdmin(admin);	
		
	}
	
	@GetMapping("admin")
	public List<Admin> getAdmin() throws AdminException {
		return this.adminService.getAdmin();

	}
	
	@PutMapping("admin")
	public Admin updateAdmin(@RequestBody Admin admin) throws AdminException {
		return this.adminService.updateAdmin(admin);
		
	}

	@DeleteMapping("admin/{adminId}/{adminPassword}")
	public String deleteAdmin(@PathVariable Integer adminId,@PathVariable String adminPassword) throws AdminException {
		return this.adminService.deleteAdmin(adminId,adminPassword);
		
	}
}
