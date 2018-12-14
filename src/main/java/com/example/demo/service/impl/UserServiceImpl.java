package com.example.demo.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.TUser;
import com.example.demo.dto.BookMangerExecutionRsp;
import com.example.demo.exception.BookMangerException;
import com.example.demo.mapper.TUserMapper;
import com.example.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private TUserMapper tusermapper;
	
	/*
	 * 注册
	 */
	@Override
	public BookMangerExecutionRsp insertUser(String username, String password) throws BookMangerException{
		// TODO Auto-generated method stub
		if(tusermapper.selectUser(username,"","") != null) {
			throw new BookMangerException("该用户名已存在！");
		}
		
		//由8~16位字母和数字组成
		String regex="^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{8,16}$";
		if(!password.trim().matches(regex)) {
			throw new BookMangerException("密码必须在8~16字之间，且由字母和数字组成");
		}
		
		try {
			int insertUserres = tusermapper.insertUser(username, password);
//			logger.error("插入数据结果insertUserres："+insertUserres);
			if(insertUserres<=0) {
				throw new BookMangerException("注册失败！");
			}else {
				return new BookMangerExecutionRsp(username, "注册成功！");
			}

		}catch(BookMangerException e) {
			logger.error(e.getMessage(),e);
			throw new BookMangerException("系统内部异常   "+e.getMessage());
		}
		
	}

	/*
	 * 登录
	 */
	@Override
	public String selectUser(String username, String password) throws BookMangerException{
		
		// TODO Auto-generated method stub
		try {
			TUser usernameinfo = tusermapper.selectUser(username, "0", "");
			if(usernameinfo==null) {
				throw new BookMangerException("您还没有注册，清先注册！");
			}else {
				TUser passwordinfo = tusermapper.selectUser(username, "0", password);
				if(passwordinfo==null) {
					throw new BookMangerException("密码错误，清重新输入！");
				}else {
					return passwordinfo.getId().toString();
				}
			}
		}catch(BookMangerException e) {
			throw e;
		}
	}

}
