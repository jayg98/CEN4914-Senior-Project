package com.example.demo.passwordResetToken;

public interface IPasswordResetTokenSchema {

	public PasswordResetToken save(PasswordResetToken passwordResetToken);

	public PasswordResetToken findByUserId(int userId);
	
	public void deleteAll();

}
