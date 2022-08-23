package com.onlinebookstore;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.onlinebookstore.dto.Admin;
import com.onlinebookstore.exception.AdminException;
import com.onlinebookstore.exception.BookException;
import com.onlinebookstore.service.AdminService;

@SpringBootTest
public class AdminServiceTest {
	
	@Autowired
	AdminService adminService;
	
	@Test
	void registerAdminTest() throws AdminException{
		assertNotNull(this.adminService.registerAdmin(null));
		assertThrows(BookException.class,()->this.bookService.addBook(null));
	}
	@Test
	void getAdminTest() throws AdminException{
		
	}
	@Test
	void updateAdminTest() throws AdminException{
		
	}
	@Test
	void deleteAdminTest() throws AdminException{
		
	}
	@Test
	void loginTest() throws AdminException{
		
	}

}
