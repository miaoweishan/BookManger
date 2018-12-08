package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.example.demo.dao.TBook;
import com.example.demo.dto.BookMangerResult;
import com.example.demo.exception.TBookDetailException;
import com.example.demo.service.BookDetailService;

@RestController
@RequestMapping("BookDetail")
public class BookDetailController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private BookDetailService bookdetailservice;
	
	//添加图书
	@PostMapping("addTbook")
	public BookMangerResult<String> addTbook(@RequestBody(required=false) String data){
		logger.info("data："+data);
		TBook datajson = JSON.parseObject(data,TBook.class);
		
		logger.info("bookName："+datajson.getBookname());
		logger.info("author："+datajson.getAuthor());
		logger.info("sex："+datajson.getSex());
		logger.info("price："+datajson.getPrice());
		logger.info("bookTypeId："+datajson.getBooktypeid());
		logger.info("bookDesc："+datajson.getBookdesc());
		
		try {
			int isaddbook = bookdetailservice.insertbook(datajson.getBookname(), datajson.getAuthor(), 
					datajson.getSex(), datajson.getPrice(), datajson.getBooktypeid(), datajson.getBookdesc());
			return new BookMangerResult<>(true, "图书添加成功！");
		}catch(TBookDetailException e) {
			logger.debug(e.getMessage());
			return new BookMangerResult<>(true, e.getMessage());
		}catch(Exception e) {
			e.printStackTrace();
			return new BookMangerResult<>(true, e.getMessage());
		}
		
	}
	
	//修改图书信息
	@PostMapping("reviseTbook")
	public BookMangerResult<String> reviseTbook(@RequestParam(value="bookname") String bookname,@RequestParam(value="reqdata") String reqdata){
		
		logger.info("reqdata: "+ reqdata);
		TBook datajson = JSON.parseObject(reqdata, TBook.class);
		logger.info("bookName："+datajson.getBookname());
		logger.info("author："+datajson.getAuthor());
		logger.info("sex："+datajson.getSex());
		logger.info("price："+datajson.getPrice());
		logger.info("bookTypeId："+datajson.getBooktypeid());
		logger.info("bookDesc："+datajson.getBookdesc());
		
		try {
			int isreviseTbook = bookdetailservice.updatebook(bookname, datajson.getBookname(), datajson.getAuthor(), 
					datajson.getSex(), datajson.getPrice(), datajson.getBooktypeid(), datajson.getBookdesc());
			return new BookMangerResult<>(true, "更新成功！");
		}catch(TBookDetailException e) {
			logger.debug(e.getMessage());
			return new BookMangerResult<>(true, e.getMessage());
		}catch(Exception e) {
			e.printStackTrace();
			return new BookMangerResult<>(true, e.getMessage());
		}
		
	}
	
	//删除图书
	@GetMapping("cutTBook")
	public BookMangerResult<String> cutTBook(@RequestParam(value="bookname") String bookname){
		
		try {
			int iscuttbook = bookdetailservice.deletebook(bookname);
			return new BookMangerResult<>(true, "图书已删除！");
		}catch(TBookDetailException e) {
			logger.debug(e.getMessage());
			return new BookMangerResult<>(true, e.getMessage());	
		}catch(Exception e) {
			e.printStackTrace();
			return new BookMangerResult<>(true, e.getMessage());
		}
		
	}
	
	//通过图书名称查询图书信息
	@GetMapping("queryTBook")
	public BookMangerResult<TBook> queryTBook(@RequestParam(value="bookname") String bookname){
		
		try {
			TBook tbookdetail = bookdetailservice.selectbook(bookname);
//			SerializerFeatureUtil.writeMapNullValue(tbookdetail);
			return new BookMangerResult<TBook>(true, tbookdetail, "图书信息查询成功！");
		}catch(TBookDetailException e) {
			logger.debug(e.getMessage());
			return new BookMangerResult<>(true, e.getMessage());	
		}catch(Exception e) {
			e.printStackTrace();
			return new BookMangerResult<>(true, e.getMessage());
		}
		
	}

}
