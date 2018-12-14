package com.example.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.TBooktype;
import com.example.demo.dto.BookMangerResult;
import com.example.demo.exception.TBookTypeException;
import com.example.demo.service.booktypeService;

@RestController
@RequestMapping("booktypemanger")
public class booktypeMangerController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private booktypeService booktypeservice;
	
	//查询已有的图书类别
	@GetMapping("Booktype")
	public BookMangerResult<List<TBooktype>> queryBooktype(){
		try {
			List<TBooktype> booktypebyall = booktypeservice.selectbooktype();
			return new BookMangerResult<>(true, booktypebyall, "查询成功！");
		}catch(TBookTypeException e) {
			logger.error(e.getMessage());
			return new BookMangerResult<>(true, e.getMessage());
		}catch(Exception e) {
			logger.error(e.getMessage());
			return new BookMangerResult<>(true, "查询图书类别失败！");
		}
		
	}
	
	//添加图书类别
	@PostMapping("addbooktype")
	public BookMangerResult<String> addBooktype(String bookTpyeName, String bookTpyeDesc){

		logger.debug("bookTpyeName: "+bookTpyeName+"   "+"bookTpyeDesc: "+bookTpyeDesc);
		try {
			int addnum = booktypeservice.insertbooktype(bookTpyeName, bookTpyeDesc);
			return new BookMangerResult<>(true, "图书类别添加成功！");
		}catch(TBookTypeException e){
			logger.error(e.getMessage());
			return new BookMangerResult<>(true, e.getMessage());
		}catch(Exception e) {
			logger.error(e.getMessage());
			return new BookMangerResult<>(true, "添加图书类别失败！");
		}
		
	}
	
	//删除图书类别
	@PostMapping("cutbooktype")
	public BookMangerResult<String> cutBooktype(String booktpyename){
		logger.debug("bookTpyeName: "+booktpyename);
		try {
			int cutnum = booktypeservice.deletebooktype(booktpyename);
			return new BookMangerResult<>(true, "图书类别删除成功！");
		}catch(TBookTypeException e) {
			logger.error(e.getMessage());
			return new BookMangerResult<>(true, e.getMessage());			
		}catch(Exception e) {
			logger.error(e.getMessage());
			return new BookMangerResult<>(true,"图书类别删除失败！");
		}
	}
		
}
