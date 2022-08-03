package com.onlinebookstore;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.onlinebookstore.dao.UserRepository;
import com.onlinebookstore.dto.User;
import com.onlinebookstore.exception.UserException;
import com.onlinebookstore.service.UserService;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
public class UserServiceTest {
	
	@Autowired
	UserService userService;
	
	@Autowired
	UserRepository userRepository;
	
	
	User user = new User(512,"Devesh","devesh@gmail.com","asdfghj",12345678,null);
	
	@Test
	public void registerUserTest() throws UserException{
		//Assertion.assumeTrue(userService != null);
		
		assertNotNull(this.userService.registerUser(user));
		assertThrows(UserException.class,()->this.userService.registerUser(null));
		
		
	}
	
	@Test
	public void getUserByIdTest() throws UserException{
		assertNotNull(this.userService.registerUser(user));
		assertNotNull(this.userService.getUserById(user.getUserId()));
		assertThrows(UserException.class,()->this.userService.getUserById(0));
		
	}
	
	@Test
	public void updateUseTest() throws UserException{
		assertNotNull(this.userService.registerUser(user));
		user.setUserName("Fardeen");
		assertNotNull(this.userService.updateUser(user));
		assertEquals("Fardeen",user.getUserName());
		assertThrows(UserException.class,()->this.userService.updateUser(null));
		
	}
	
	
//	@Test
//	public void deleteUserByIdTest() throws UserException{
//		assertNotNull(this.userService.registerUser(user));
//		assertEquals("Successful",this.userService.deleteUserById(user.getUserId()));
//		assertThrows(UserException.class,()->this.userService.deleteUserById(0));
//		
//	}
	
	@Test
	public void getAllUserTest() throws UserException{
		
		assertNotNull(this.userService.registerUser(user));
		assertNotNull(this.userService.getAllUser());
		this.userRepository.deleteAll();
		assertThrows(UserException.class,()->this.userService.getAllUser());
		
	}
	
	@AfterEach
	public void deleteUserTestData() throws UserException{
		//assertNotNull(this.userService.registerUser(user));
	    assertEquals("Successful",this.userService.deleteUserById(user.getUserId()));
		assertThrows(UserException.class,()->this.userService.deleteUserById(0));
	}

}
