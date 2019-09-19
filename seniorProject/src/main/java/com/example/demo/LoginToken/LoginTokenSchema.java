package com.example.demo.LoginToken;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.example.demo.exceptions.FakeDbException;

public class LoginTokenSchema{
	
	List<LoginToken> loginTokens;
	
	public LoginToken save(LoginToken token){
		int userId = token.getUserId();
		for(int i = 0; i < loginTokens.size(); i++) {
			if(userId == loginTokens.get(i).getUserId()) {
				throw new FakeDbException("user already existed");
			}
		}
		
		loginTokens.add(token);
		return token;
		
	}
	
	public LoginToken update(LoginToken token){
		
		LoginToken retrievedToken = null;
		
		for (int i = 0; i < loginTokens.size(); i++){
			if(loginTokens.get(i).getUserId() == token.getUserId()){
				retrievedToken = loginToken.get(i);
			}
		}
		retrievedToken.expirationDate = token.expirationDate;
		retrievedToken.tokenString = token.getTokenString();
		
		return token;
	}
	
	public LoginToken findByUserId(int userId){
		
		LoginToken foundToken = null;
		
		for(int i = 0; i < loginTokens.size(); i++){
			if(loginTokens.get(i).getUserId() == userId){
				foundToken = loginTokens.get(i);
			}
		}
		
		return foundToken;
	}
	
	

}
