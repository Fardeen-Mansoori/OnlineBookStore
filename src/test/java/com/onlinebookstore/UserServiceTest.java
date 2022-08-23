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
	
	
	
	User user = new User(599,"Devesh","12345678","devesh@gmail.com","Delhi,India","1234567890",null);
	
	
	

	@Test
	public void registerUserTest() throws UserException{
		//Assertion.assumeTrue(userService != null);
		user = this.userService.registerUser(user);
		//assertNotNull(this.userService.registerUser(user));
		assertNotNull(user);
		assertThrows(UserException.class,()->this.userService.registerUser(null));
		assertEquals("Successful",this.userService.deleteUserById(user.getUserId()));
		
		
		
	}
	
	@Test
	public void getUserByIdTest() throws UserException{
		user = this.userService.registerUser(user);
		assertNotNull(this.userService.getUserById(user.getUserId()));
		assertThrows(UserException.class,()->this.userService.getUserById(0));
		assertEquals("Successful",this.userService.deleteUserById(user.getUserId()));
		
		
	}

	@Test
	public void updateUseTest() throws UserException{
		user = this.userService.registerUser(user);
		user.setUserName("Fardeen");
		assertNotNull(this.userService.updateUser(user));
		assertEquals("Fardeen",user.getUserName());
		assertThrows(UserException.class,()->this.userService.updateUser(null));
		assertEquals("Successful",this.userService.deleteUserById(user.getUserId()));
		
		
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
		
		user = this.userService.registerUser(user);
		assertNotNull(this.userService.getAllUser());
		assertEquals("Successful",this.userService.deleteUserById(user.getUserId()));
		//this.userRepository.deleteAll();
		//assertThrows(UserException.class,()->this.userService.getAllUser());
		
	}
	
//	@AfterEach
//	public void deleteUserTestData() throws UserException{
//		//assertNotNull(this.userService.registerUser(user));
//	    assertEquals("Successful",this.userService.deleteUserById(user.getUserId()));
//		assertThrows(UserException.class,()->this.userService.deleteUserById(0));
//	}

}
