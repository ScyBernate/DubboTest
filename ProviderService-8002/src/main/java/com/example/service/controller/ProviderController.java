package com.example.service.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProviderController {

    @HystrixCommand(fallbackMethod = "fallback")
    @RequestMapping(value = "/getResult", method = RequestMethod.GET)
    public int count(){
        return  8002;
    }

    public int fallback(){
        return 9992;
    }
}
