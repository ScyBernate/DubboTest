package com.configdemo.configClient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



/**
 * Hello world!
 *
 */
@SpringBootApplication
@RestController
public class Application {
    @Value("${username}")
    String username;
    
    @Value("${password}")
    String password;

    @RequestMapping("/")
    String hello() {
        return "Hello " + username + "!" + "password:"+password;
    }

    public static void main(String[] args) {
    	SpringApplication.run(Application.class, args);
    }
}
