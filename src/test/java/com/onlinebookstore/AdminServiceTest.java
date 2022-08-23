package com.onlinebookstore;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.onlinebookstore.dao.AdminRepository;
import com.onlinebookstore.dto.Admin;
import com.onlinebookstore.exception.AdminException;
import com.onlinebookstore.exception.BookException;
import com.onlinebookstore.service.AdminService;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class AdminServiceTest {
	
	@Autowired
	AdminService adminService;
	
	@Autowired
	AdminRepository adminRepository;
	
	
	Admin admin = new Admin(1000,"faisal@123");
	
	@Test
	void registerAdminTest() throws AdminException{
		assertEquals("Admin registered Suceessfully",this.adminService.registerAdmin(admin));
		assertThrows(AdminException.class,()->this.adminService.registerAdmin(null));
	}
	@Test
	void getAdminTest() throws AdminException{
		assertEquals("Admin registered Suceessfully",this.adminService.registerAdmin(admin));
		assertNotNull(this.adminService.getAdmin());
		
	}
	@Test
	void updateAdminTest() throws AdminException{
		assertEquals("Admin registered Suceessfully",this.adminService.registerAdmin(admin));
		admin.setAdminPassword("faisal123");
		assertEquals("Admin Updated Successfully",this.adminService.updateAdmin(admin));
		assertThrows(AdminException.class,()->this.adminService.updateAdmin(null));
	}
	
	@Test
	void loginTest() throws AdminException{
		assertEquals("Admin registered Suceessfully",this.adminService.registerAdmin(admin));
		assertTrue(this.adminService.login(admin.getAdminId(), admin.getAdminPassword()));
		assertThrows(AdminException.class,()->this.adminService.login(admin.getAdminId()+1, admin.getAdminPassword()));
		
	}
	@AfterEach
	void deleteAdminTest() throws AdminException{
		assertEquals("Successful",this.adminService.deleteAdmin(admin.getAdminId(), admin.getAdminPassword()));
		assertThrows(AdminException.class,()->this.adminService.deleteAdmin(admin.getAdminId()+1, admin.getAdminPassword()));
	}

}
