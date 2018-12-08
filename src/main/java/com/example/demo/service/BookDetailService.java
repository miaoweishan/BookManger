package com.example.demo.service;

import com.example.demo.dao.TBook;
import com.example.demo.exception.TBookDetailException;

public interface BookDetailService {
	//新增图书
	int insertbook(String bookName,String author,String sex,long price,int bookTypeId,String bookDesc)
	throws TBookDetailException;
	
	//修改图书信息
	int updatebook(String bookname,String newbookname,String author,String sex,long price,int bookTypeId,String bookDesc)
	throws TBookDetailException;
	
	//逻辑删除图书
	int deletebook(String bookname) throws TBookDetailException;
	
	//查询图书信息
	TBook selectbook(String bookname) throws TBookDetailException;
}
