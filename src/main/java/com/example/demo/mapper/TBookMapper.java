package com.example.demo.mapper;

import com.example.demo.dao.TBook;
import com.example.demo.utils.MyMapper;

public interface TBookMapper extends MyMapper<TBook> {
	//新增图书
	int insertbook(String bookName,String author,String sex,long price,int bookTypeId,String bookDesc);
	
	//修改图书信息
	int updatebook(String bookname,String newbookname,String author,String sex,long price,int bookTypeId,String bookDesc);
	
	//逻辑删除图书
	int deletebook(String bookname);
	
	//查询图书信息
	TBook selectbook(String bookname);
	
}