package com.example.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CounterController {

    @Autowired
    private RestTemplate template;

    @RequestMapping(value = "/getResult", method = RequestMethod.GET)
    public int getResult(){
        return template.getForObject("http://PROVIDERSERVICE/getResult",Integer.class);
    }
}
