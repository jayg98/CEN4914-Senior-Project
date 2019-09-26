package com.example.demo.user;

import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;

import org.junit.Test;

import com.example.demo.passwordResetToken.PasswordResetToken;
import com.example.demo.passwordResetToken.PasswordResetTokenSchema;
import com.example.demo.user.UserSchema;
import com.example.demo.user.UserService;

public class UserServiceTest {
	
	@Test
	public void resetPasswordWithExistedUserAndPasswordResetTokenShouldReturnTrue() {
		
		boolean reset = false;
		
		UserService userService = new UserService();                                                        
		
		UserSchema userSchema = new UserSchema();
		
		User user = new User();
		user.setUseremail("Saito@gmail.com");
		user.setPassword("Saito");
		user.setUserId(userSchema.getNextId());
		
		userSchema.save(user);
		
		PasswordResetTokenSchema passwordResetTokenSchema = new PasswordResetTokenSchema();
		
		PasswordResetToken passwordResetToken = new PasswordResetToken();
		passwordResetToken.setUserId(user.getUserId());
		
		passwordResetTokenSchema.save(passwordResetToken);
		
		reset = userService.resetPassword("Saito@gmail.com", userSchema, passwordResetTokenSchema);
	
		assertTrue(reset == true);
		
	}
	
	@Test
	public void resetPasswordWithNotExistedUserShouldReturnFalse() {
		
		boolean reset = false;
		
		UserService userService = new UserService();                                                        
		
		UserSchema userSchema = new UserSchema();
		
		PasswordResetTokenSchema passwordResetTokenSchema = new PasswordResetTokenSchema();
		
		reset = userService.resetPassword("Saito@gmail.com", userSchema, passwordResetTokenSchema);
	
		assertTrue(reset == false);
		
	}
	
	@Test
	public void resetPasswordWithNotExistedPasswordResetTokenShouldReturnFalse() {
		
		boolean reset = false;
		
		UserService userService = new UserService();                                                        
		
		UserSchema userSchema = new UserSchema();
		
		User user = new User();
		user.setUseremail("Saito@gmail.com");
		user.setPassword("Saito");
		user.setUserId(userSchema.getNextId());
		
		userSchema.save(user);
		
		PasswordResetTokenSchema passwordResetTokenSchema = new PasswordResetTokenSchema();
		
		reset = userService.resetPassword("Saito@gmail.com", userSchema, passwordResetTokenSchema);
	
		assertTrue(reset == false);
		
	}
	
	@Test
	public void changePasswordWithNotMatchedPasswordResetTokenStringShouldReturnFalse() {
		
		boolean reset = false;
			
		UserService userService = new UserService();                                                        
		
		UserSchema userSchema = new UserSchema();
		
		User user = new User();
		user.setUseremail("Saito@gmail.com");
		user.setPassword("Saito");
		user.setUserId(userSchema.getNextId());
		
		userSchema.save(user);
		
		PasswordResetTokenSchema passwordResetTokenSchema = new PasswordResetTokenSchema();
		
		PasswordResetToken passwordResetToken = new PasswordResetToken();
		passwordResetToken.setUserId(user.getUserId());
		passwordResetToken.setTokenString("123456789");
		passwordResetToken.setExpirationDate(LocalDateTime.now().plusMinutes(999999));
		
		passwordResetTokenSchema.save(passwordResetToken);
		
		reset 
		= userService.changePassword(
				user.getUserId(), 
				"abcdefghi", 
				userSchema, 
				passwordResetTokenSchema);
	
		assertTrue(reset == false);
		
	}
	
	@Test
	public void changePasswordWithExpiredPasswordResetTokenShouldReturnFalse() {
		
		boolean reset = false;
			
		UserService userService = new UserService();                                                        
		
		UserSchema userSchema = new UserSchema();
		
		User user = new User();
		user.setUseremail("Saito@gmail.com");
		user.setPassword("Saito");
		user.setUserId(userSchema.getNextId());
		
		userSchema.save(user);
		
		PasswordResetTokenSchema passwordResetTokenSchema = new PasswordResetTokenSchema();
		
		PasswordResetToken passwordResetToken = new PasswordResetToken();
		passwordResetToken.setUserId(user.getUserId());
		passwordResetToken.setTokenString("123456789");
		passwordResetToken.setExpirationDate(LocalDateTime.now().minusMinutes(10));
		
		passwordResetTokenSchema.save(passwordResetToken);
		
		reset 
		= userService.changePassword(
				user.getUserId(), 
				"123456789", 
				userSchema, 
				passwordResetTokenSchema);
	
		assertTrue(reset == false);
		
	}
	
}
