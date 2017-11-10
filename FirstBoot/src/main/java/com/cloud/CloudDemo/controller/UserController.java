package com.cloud.CloudDemo.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cloud.CloudDemo.Service.UserService;
import com.cloud.CloudDemo.model.User;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("user")
@Api("userController相关api")
public class UserController extends BaseController{

	@Autowired
	private UserService userService;

	@ApiOperation("获取所有用户信息")
	@ApiResponses({ @ApiResponse(code = 400, message = "请求参数没填好"),
			@ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对") })
	@RequestMapping(value = "/getUserAll", method = RequestMethod.GET)
	public ResponseEntity<List<User>> getUser() {
		Sort sort = new Sort(Sort.Direction.DESC, "id");
		Pageable pageable = new PageRequest(1, 10, sort);
		return success(userService.findAll(pageable));
	}
	
	@ApiOperation("获取所有男用户信息")
	@ApiResponses({ @ApiResponse(code = 400, message = "请求参数没填好"),
			@ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对") })
	@ApiImplicitParams({
		@ApiImplicitParam(paramType = "query", name = "sex", dataType = "String", required = true, value = "查询的性别", defaultValue = "男") })
	@RequestMapping(value = "/getMaleUser", method = RequestMethod.GET)
	public ResponseEntity<List<User>> getMaleList(@RequestParam("sex")String sex){
		Sort sort = new Sort(Sort.Direction.DESC, "id");
		Pageable pageable = new PageRequest(1, 10, sort);
		return success(userService.findMaleList(sex, pageable));
	}
	
	@ApiOperation("插入数据")
	@ApiResponses({ @ApiResponse(code = 400, message = "请求参数没填好"),
			@ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对") })
	@RequestMapping(value = "/insertUsers", method = RequestMethod.GET)
	public ResponseEntity<Integer> insertData(){
		int i = 0;
		while(i<=30){
			User u = new User("小明"+i, "123456", "test"+i, 1, "男", i+"@hotmail.com", "13512352345", "", 
					1, "superAdmin", new Date(), "", new Date(), 0, "", 0);
			if(i<=15){
				u.setSex("女");
			}
			userService.insetUser(u);
			i++;
		}
		return success();
	}

}
