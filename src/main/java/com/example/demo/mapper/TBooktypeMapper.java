package com.example.demo.mapper;

import java.util.List;

import com.example.demo.dao.TBooktype;
import com.example.demo.utils.MyMapper;

public interface TBooktypeMapper extends MyMapper<TBooktype> {
	//查询图书类别
	List<TBooktype> selectbooktype();
	
	//根据图书类别名称查询图书类别信息
	TBooktype selectbooktypebybtname(String booktpyename);
	
	//插入图书类别
	int insertbooktype(String bookTpyeName,String bookTpyeDesc);
	
	//删除图书类别
	int deletebooktype(String booktpyename);
}