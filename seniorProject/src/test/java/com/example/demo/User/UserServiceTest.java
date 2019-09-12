package com.example.demo.User;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.example.demo.user.UserSchema;
import com.example.demo.user.UserService;

public class UserServiceTest {
	
	@Test
	public void loginWithExistedUseremailAndPasswordShouldReturnTure() {
		UserSchema userSchema = new UserSchema();
		
		UserService userService = new UserService();
		boolean isLogined = userService.login("abc@gmail.com", "", userSchema);
		
		assertTrue(isLogined == true);
	}
	
	

}
