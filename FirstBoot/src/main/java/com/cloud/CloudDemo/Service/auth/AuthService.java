package com.cloud.CloudDemo.Service.auth;

import com.cloud.CloudDemo.model.User;

public interface AuthService {
	
	User register(User user);
	
	String login(String username, String password);
	
	String refresh(String oldToken);

}
