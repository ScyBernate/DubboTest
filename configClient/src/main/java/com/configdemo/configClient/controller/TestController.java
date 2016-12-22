package com.configdemo.configClient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	 @Value("${username}")
	    String username;
	    
	    @Value("${password}")
	    String password;

	    @RequestMapping("/")
	    String hello() {
	        return "Hello " + username + "!" + "password:"+password;
	    }
	
}
