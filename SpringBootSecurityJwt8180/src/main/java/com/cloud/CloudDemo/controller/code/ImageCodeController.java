package com.cloud.CloudDemo.controller.code;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class ImageCodeController {
	
	private Logger logger = LoggerFactory.getLogger(ImageCodeController.class);

	@RequestMapping(value = "/getImageCode", method = RequestMethod.GET)
	public void getUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("image/jpeg"); // 禁止图像缓存。
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		CreateImageCode vCode = new CreateImageCode(110, 33, 5, 10);
		request.getSession().setAttribute("code", vCode.getCode());
		logger.info("验证码为：{}",vCode.getCode());
		vCode.write(response.getOutputStream());
	}
}
