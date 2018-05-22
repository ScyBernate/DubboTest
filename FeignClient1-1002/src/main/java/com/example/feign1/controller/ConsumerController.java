package com.example.feign1.controller;

import com.example.feign1.bean.User;
import com.example.feign1.biz.UserBiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {

    @Autowired
    private UserBiz biz;

    @RequestMapping(value = "/getResult", method = RequestMethod.GET)
    public int getuserinfo() {
        return biz.count();
    }

}
