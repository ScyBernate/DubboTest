package com.cloud.CloudDemo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class BaseController {
	
	public ResponseEntity<Integer> success(){
		return new ResponseEntity<Integer>(HttpStatus.OK);
	}
	
	public <T> ResponseEntity<T> success(T t){
		return new ResponseEntity<T>(t,HttpStatus.OK);
	}
	
	public ResponseEntity<Integer> fail(){
		return new ResponseEntity<Integer>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
