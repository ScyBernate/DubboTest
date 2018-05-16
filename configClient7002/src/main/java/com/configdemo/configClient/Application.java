package com.configdemo.configClient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;



/**
 * Hello world!
 *
 */
@EnableAutoConfiguration
@ComponentScan
@SpringBootApplication
public class Application {
   

    public static void main(String[] args) {
    	SpringApplication.run(Application.class, args);
    }
}
