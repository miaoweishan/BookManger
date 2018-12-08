package com.example.demo.service;

import java.util.List;

import com.example.demo.dao.TBooktype;
import com.example.demo.exception.TBookTypeException;

public interface booktypeService {
	//查询图书类别
	List<TBooktype> selectbooktype()
	throws TBookTypeException;
	
	//插入图书类别
	int insertbooktype(String bookTpyeName,String bookTpyeDesc)
	throws TBookTypeException;
	
	//删除图书类别
	int deletebooktype(String booktpyename)
	throws TBookTypeException;
	
	//根据图书类别名称查询图书类别信息
	TBooktype selectbooktypebybtname(String booktpyename)
	throws TBookTypeException;;
}
