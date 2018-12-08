package com.example.demo.mapper;

import com.example.demo.dao.TUser;
import com.example.demo.utils.MyMapper;

public interface TUserMapper extends MyMapper<TUser> {
	/*
	 * 插入用户信息
	 */
	int insertUser(String username, String password);
	
	/*
	 * 多条件查询用户信息
	 */
	TUser selectUser(String username,Object isdelete,String password);
	
	/*
	 * 更新数据
	 */
	int updateUser(String username,String password,String isdelete);
}