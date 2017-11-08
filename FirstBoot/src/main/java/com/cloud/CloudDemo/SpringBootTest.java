package com.cloud.CloudDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


/**
 * 
 * @author Administrator
 *
 */

@SpringBootApplication
@ComponentScan  
@EnableAutoConfiguration
public class SpringBootTest {	
	

	public static void main(String[] args) {
		System.out.println("SpringBoot应用启动.......");
		SpringApplication.run(SpringBootTest.class, args);
	}
}
