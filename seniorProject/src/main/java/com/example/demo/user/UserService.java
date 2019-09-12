package com.example.demo.user;

public class UserService {
	
	public String firstLogin(String useremail, String password, UserSchema userSchema) {
		
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

