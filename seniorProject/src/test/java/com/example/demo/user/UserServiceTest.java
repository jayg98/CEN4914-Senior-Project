package com.example.demo.user;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.example.demo.passwordResetToken.PasswordResetToken;
import com.example.demo.passwordResetToken.PasswordResetTokenSchema;
import com.example.demo.user.UserSchema;
import com.example.demo.user.UserService;

public class UserServiceTest {
	
	@Test
	public void resetPasswordWithExistedUserAndPasswordResetTokenShouldReturnTrue() {
		
		boolean reset = false;
		
		UserSchema userSchema = new UserSchema();
		PasswordResetTokenSchema passwordResetTokenSchema = new PasswordResetTokenSchema();
		
		UserService userService = new UserService();                                                        
		
		User user = new User();
		user.setUseremail("Saito@gmail.com");
		user.setPassword("Saito");
		user.setUserId(userSchema.getNextId());
		
		userSchema.save(user);
		
		PasswordResetToken passwordResetToken = new PasswordResetToken();
		passwordResetToken.setUserId(user.getUserId());
		passwordResetTokenSchema.save(passwordResetToken);
		
		reset = userService.resetPassword("Saito@gmail.com", userSchema, passwordResetTokenSchema);
	
		assertTrue(reset == true);
		
	}
	
	@Test
	public void resetPasswordWithNotExistedUserShouldReturnFalse() {
		
		boolean reset = false;
		
		UserSchema userSchema = new UserSchema();
		PasswordResetTokenSchema passwordResetTokenSchema = new PasswordResetTokenSchema();
		
		UserService userService = new UserService();                                                        
		
		reset = userService.resetPassword("Saito@gmail.com", userSchema, passwordResetTokenSchema);
	
		assertTrue(reset == false);
		
	}
	
	@Test
	public void resetPasswordWithNotExistedPasswordResetTokenShouldReturnFalse() {
		
		boolean reset = false;
		
		UserSchema userSchema = new UserSchema();
		PasswordResetTokenSchema passwordResetTokenSchema = new PasswordResetTokenSchema();
		
		UserService userService = new UserService();                                                        
		
		User user = new User();
		user.setUseremail("Saito@gmail.com");
		user.setPassword("Saito");
		user.setUserId(userSchema.getNextId());
		
		userSchema.save(user);
		
		reset = userService.resetPassword("Saito@gmail.com", userSchema, passwordResetTokenSchema);
	
		assertTrue(reset == false);
		
	}
	

}
