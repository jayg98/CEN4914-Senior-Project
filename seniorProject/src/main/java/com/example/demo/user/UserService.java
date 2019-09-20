package com.example.demo.user;

import com.example.demo.LoginToken.LoginToken;
import java.security.SecureRandom;


public class UserService {
	UserSchema userSchema = new UserSchema();
	
	public UserSchema() {
		userSchema = new UserSchema();
	}
	public LoginToken firstLogin(String useremail, String password, UserSchema userSchema) {
		this.useremail = useremail;
		this.password = password;
		
		if(findByUseremail(useremail) == null || password != getPassword() ) {
			throw new userInfoNotMatching("E-mail or password incorrect. Try again.")
			
		}
			
		else {
			userId = getUserId();
			loginToken = getTokenString();
			
			protected static SecureRandom random = new SecureRandom();
			public synchronized String generateToken(String userId) {
                long longToken = Math.abs( random.nextLong() );
                String random = Long.toString( longToken, 16 );
                newTokenString = (userId + ":" + random);
                return newTokenString;
                }
			
			string firstLoginToken = setTokenString(newTokenString);
			string loginToken = firstLoginToken;
			
}
			
			}	
	}
	
	public boolean secondLogin(
			String firstLoginToken, Image userImage, 
			ImageComparer imageComparer, EmotionDetector emtionDector) {
		
	}
	
	public boolean register(String useremail, String password, Image userImage) {
	
		
	}
	
	public void resetPassword(String useremail, PasswordResetTokenSchema passwordResetTokenSchema) {
		int id = userSchema.findidByUseremail(useremail);
		Token token =  tokenSchema.findTokenById(id);
		token.resetToken();
		tokenSchema.save(token);
	}
	
	public void changePassword(int id, (String tokenString, String newPassword) {
		
	}
	
}

