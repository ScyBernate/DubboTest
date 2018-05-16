package com.cloud.CloudDemo.Service.auth;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.cloud.CloudDemo.Service.UserService;
import com.cloud.CloudDemo.config.security.JwtTokenUtil;
import com.cloud.CloudDemo.config.security.SecUser;
import com.cloud.CloudDemo.model.User;

@Service
public class AuthServiceImpl implements AuthService {
	
	@Value("${jwt.tokenHead}")
    private String tokenHead;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	@Autowired
	private UserService userService;

	@Override
	public String login(String username, String password) {
		UsernamePasswordAuthenticationToken upToken = new UsernamePasswordAuthenticationToken(username, password);
        final Authentication authentication = authenticationManager.authenticate(upToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        final UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        final String token = jwtTokenUtil.generateToken(userDetails);
		return token;
	}

	@Override
	public String refresh(String oldToken) {
		final String token = oldToken.substring(tokenHead.length());
        String username = jwtTokenUtil.getUsernameFromToken(token);
        SecUser user = (SecUser) userDetailsService.loadUserByUsername(username);
        if (jwtTokenUtil.canTokenBeRefreshed(token, user.getLastPasswordResetDate())){
            return jwtTokenUtil.refreshToken(token);
        }
        return null;
	}

	@Override
	public User register(User user) {
		final String username = user.getUsername();
        if(userService.findByUsername(username)!=null) {
            return null;
        }
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        final String rawPassword = user.getPassword();
        User u = new User("NA", encoder.encode(rawPassword), username, 1, "女", "shengchongyang@hotmail.com", "", "13512352345", 
				1, "", new Date(), "", new Date(), 1, "", 0, new Date());
        userService.insetUser(u);
        return user;
	}

}
