package com.cloud.CloudDemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("test")
public class TestController {
	
	@RequestMapping(value = "/index")
	String index() {
		return "index";
	}
	

}
