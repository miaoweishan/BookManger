package com.example.demo.service;

import com.example.demo.dto.BookMangerExecutionRsp;
import com.example.demo.exception.BookMangerException;

public interface UserService {
	//注册
	BookMangerExecutionRsp insertUser(String username, String password)
	throws BookMangerException;
	
	//登录
	String selectUser(String username,String passeord)
	throws BookMangerException;
	
	
}
