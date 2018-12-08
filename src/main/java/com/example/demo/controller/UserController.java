package com.example.demo.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.BookMangerExecutionRsp;
import com.example.demo.dto.BookMangerResult;
import com.example.demo.exception.BookMangerException;
import com.example.demo.service.UserService;
import com.example.demo.utils.CookieUtils;

@RestController
@RequestMapping("bookmanger")
public class UserController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private UserService bookmangerservice;
	
	//用户注册
	@PostMapping("userRegister")
	public BookMangerResult<BookMangerExecutionRsp> userRegister(String username,String password){
		logger.error("入参username："+username);
		logger.error("入参password："+password);
		if(username==null || username.trim().equals("")) {
			return new BookMangerResult<BookMangerExecutionRsp>(false, "用户名不能为空！");
		}else if(password==null || password.trim().equals("")) {
			return new BookMangerResult<>(false, "密码不能为空！");
		}
		try {
			BookMangerExecutionRsp userregisterrsp= bookmangerservice.insertUser(username, password);
			return new BookMangerResult<BookMangerExecutionRsp>(true, userregisterrsp);
		}catch(BookMangerException e) {
//			logger.error(e.getMessage());
			return new BookMangerResult<>(false, e.getMessage());
		}	
	}
	
	//登录
	@GetMapping("userLogin")
	public BookMangerResult<String> userLogin(
			@RequestParam String username,@RequestParam String password){
		logger.error("入参username："+username+"    password："+password);
		
		if(StringUtils.isBlank(username)) {
			return new BookMangerResult<>(false, "请输入用户名！");
		}else if(StringUtils.isBlank(password)) {
			return new BookMangerResult<>(false, "请输入密码！");
		}
		
		try {
			String um = bookmangerservice.selectUser(username, password);
			CookieUtils.setCookie("username", username, 1000);
			
			return new BookMangerResult<>(true, "登录成功");
		}catch(BookMangerException e) {
			logger.error(e.getMessage());
			return new BookMangerResult<>(false, e.getMessage());
		}
		
	}
	
	

}
