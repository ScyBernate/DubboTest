package com.cloud.CloudDemo.controller.auth;

import javax.servlet.http.HttpServletRequest;

import com.cloud.CloudDemo.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cloud.CloudDemo.Service.auth.AuthService;
import com.cloud.CloudDemo.config.security.JwtAuthenticationRequest;
import com.cloud.CloudDemo.model.User;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * 
  * @ClassName: AuthController
  * @Description: token  Controller
  * @author scy
  * @date 2017年11月13日 上午11:32:39
  * @question: 关于jwt：当你refresh一个新的token的时候，原本的token并不会立刻失效，还是能通过这个token来获取资源，
  *       只有超过它设置的expire时间，它才能自动失效（当前设置失效时间为1分钟）
  *
 */
@Api("AuthController相关api")
@RestController
public class AuthController extends BaseController{
    @Value("${jwt.header}")
    private String tokenHeader;

    @Autowired
    private AuthService authService;

    @ApiOperation("获取token")
	@ApiResponses({ @ApiResponse(code = 400, message = "请求参数没填好"),
			@ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对") })
    @RequestMapping(value = "${jwt.route.authentication.path}", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtAuthenticationRequest authenticationRequest) throws AuthenticationException{
        final String token = authService.login(authenticationRequest.getUsername(), authenticationRequest.getPassword());
        // Return the token
        System.out.println(ResponseEntity.ok(token));
        return success(token);
    }

    @ApiOperation("刷新token")
  	@ApiResponses({ @ApiResponse(code = 400, message = "请求参数没填好"),
  			@ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对") })
    @RequestMapping(value = "${jwt.route.authentication.refresh}", method = RequestMethod.GET)
    public ResponseEntity<?> refreshAndGetAuthenticationToken(
            HttpServletRequest request) throws AuthenticationException{
        String token = request.getHeader(tokenHeader);
        String refreshedToken = authService.refresh(token);
        if(refreshedToken == null) {
            return ResponseEntity.badRequest().body(null);
        } else {
            return ResponseEntity.ok(refreshedToken);
        }
    }
    
    @ApiOperation("注册用户")
  	@ApiResponses({ @ApiResponse(code = 400, message = "请求参数没填好"),
  			@ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对") })
    @RequestMapping(value = "${jwt.route.authentication.register}", method = RequestMethod.POST)
    public User register(@RequestBody User user) throws AuthenticationException{
        return authService.register(user);
    }

}

