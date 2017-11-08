package com.cloud.CloudDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * 
 * @author Administrator
 *
 */

@SpringBootApplication
@EnableAutoConfiguration
public class SpringBootTest {	
	

	public static void main(String[] args) {
		System.out.println("SpringBoot应用启动.......");
		SpringApplication.run(SpringBootTest.class, args);
	}
}
