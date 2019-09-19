package com.example.demo.LoginToken;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class LoginTokenSchema{
	
	List<LoginToken> loginTokens;
	
	public LoginToken save(LoginToken token){
		
		
		return token;
		
	}
	
	public LoginToken update(LoginToken token){
		
		token.expirationDate = LocalDateTime.now();
		token.getTokenString();
		
		return token;
	}
	
	public LoginToken findByUserId(int userId){
		
		LoginToken foundToken;
		
		for(int i = 0; i < loginTokens.size(); i++){
			if(loginTokens.get(i).getUserId() == userId){
				foundToken = loginTokens.get(i);
			}
		}
		
		return foundToken;
	}
	
	

}
