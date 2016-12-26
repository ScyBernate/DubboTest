package com.cloud.CloudDemo.Listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cloud.CloudDemo.SpringBootTest;

/**
 * 初始化123
 * @author Administrator
 *
 */
@SpringBootApplication
@EnableAutoConfiguration
public class MyListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent sc) {
		System.out.println("ServletContextListener销毁!");

	}

	@Override
	public void contextInitialized(ServletContextEvent sc) {
		System.out.println("ServletContextListener初始化成功!");
	}

	public static void main(String[] args) {
		System.out.println("SpringBoot应用启动.......");
		
		SpringApplication.run(MyListener.class, args);
	}
}
