package com.cloud.CloudDemo.controller;

import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cloud.CloudDemo.model.User;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.validation.constraints.Null;

@RestController
@RequestMapping("test")
@Api("testController相关api")
public class TestController {
	
 @ApiOperation("获取用户信息")
    @ApiImplicitParams({
        @ApiImplicitParam(paramType="header",name="username",dataType="String",required=true,value="用户的姓名",defaultValue="zhaojigang"),
        @ApiImplicitParam(paramType="query",name="password",dataType="String",required=true,value="用户的密码",defaultValue="wangna")
    })
    @ApiResponses({
        @ApiResponse(code=400,message="请求参数没填好"),
        @ApiResponse(code=404,message="请求路径没有或页面跳转路径不对")
    })
 
	 @RequestMapping(value="/getUser",method=RequestMethod.GET)
	 public User getUser(@RequestHeader("username") String username, @RequestParam("password") String password) {
	     return new User();
	 }

    @RequestMapping(value="/testException",method=RequestMethod.GET)
	 public User testException(){
        int i = 0;
        if(i==0){
            throw new RuntimeException();
        }
        return new User();
     }

}
