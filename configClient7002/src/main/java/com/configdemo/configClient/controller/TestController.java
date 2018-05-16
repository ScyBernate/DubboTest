package com.configdemo.configClient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>类名：TestController.java</p>
 * <p>描述：获取配置文件属性</p>
 * <p>作者： Administrator</p>
 * <p>日期：2016年12月22日</p>
 */
@RestController
@RefreshScope
public class TestController {

    @Value("${username}")
    String username;

    @Value("${password}")
    String password;


    @RequestMapping("/")
    public String hello() {
        return "Hello " + username + "!" + "password:" + password;
    }

}
