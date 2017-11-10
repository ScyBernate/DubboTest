package com.cloud.CloudDemo.Listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;


/**
 * 初始化123
 * @author Administrator
 *
 */
@WebListener
public class MyListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent sc) {
		System.out.println("ServletContextListener销毁!");

	}

	@Override
	public void contextInitialized(ServletContextEvent sc) {
		System.out.println("ServletContextListener初始化成功!");
	}

}
