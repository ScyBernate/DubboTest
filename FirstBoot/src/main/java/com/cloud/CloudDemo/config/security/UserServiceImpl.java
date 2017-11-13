package com.cloud.CloudDemo.config.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.cloud.CloudDemo.Service.UserService;
import com.cloud.CloudDemo.model.User;

@Component
public class UserServiceImpl implements UserDetailsService{
	
	private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	private UserService userService;

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		try {
			User user = userService.findByUsername(username);
			logger.debug("{}用户信息：{}",username,user);
			if(user==null){
				throw new Exception("no user found for "+username);
			}
			return new SecUser(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
