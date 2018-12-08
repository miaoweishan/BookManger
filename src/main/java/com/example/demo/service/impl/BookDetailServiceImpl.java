package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.TBook;
import com.example.demo.exception.TBookDetailException;
import com.example.demo.mapper.TBookMapper;
import com.example.demo.service.BookDetailService;

@Service
public class BookDetailServiceImpl implements BookDetailService{

	@Autowired
	private TBookMapper tbookmapper;
	
	//添加图书信息
	@Override
	public int insertbook(String bookName, String author, String sex, long price, int bookTypeId, String bookDesc) 
			throws TBookDetailException{
		
		if(bookName==null || bookName.trim().equals("")) {
			throw new TBookDetailException("图书名称不可为空！");
		}else if(author==null || author.trim().equals("")) {
			throw new TBookDetailException("作者不可为空！");
		}else if(sex==null || sex.trim().equals("")) {
			throw new TBookDetailException("性别不可为空！");
		}else if(price < 0) {
			throw new TBookDetailException("清填写正确的价格！");
		}else if(bookTypeId==0) {
			throw new TBookDetailException("图书类别不可为空！");
		}else if(bookDesc==null || bookDesc.trim().equals("")) {
			throw new TBookDetailException("请填写该图书的说明！");
		}
		
		TBook bookdetail = tbookmapper.selectbook(bookName);
		if(bookdetail !=null) {
			throw new TBookDetailException("图书信息已经被添加，请勿重复添加！");
		}
		
		
		int inbook = tbookmapper.insertbook(bookName, author, sex, price, bookTypeId, bookDesc);
		if(inbook==0) {
			throw new TBookDetailException("图书信息添加失败！");
		}
		return inbook;
	}

	//修改图书信息
	@Override
	public int updatebook(String bookname, String newbookname, String author, String sex, long price, int bookTypeId,
			String bookDesc) throws TBookDetailException{
		
		if(bookname == null || bookname.trim().equals("")) {
			throw new TBookDetailException("清选择要修改的图书！");
		}
		
		TBook bookdetail = tbookmapper.selectbook(bookname);
		if(bookdetail == null) {
			throw new TBookDetailException("未查询到该图书信息！");
		}
		
		if(newbookname == null || newbookname.trim().equals("")) {
			int upbook = tbookmapper.updatebook(bookname, bookname, author, sex, price, bookTypeId, bookDesc);
			return upbook;
		}else {
			int upbook = tbookmapper.updatebook(bookname, newbookname, author, sex, price, bookTypeId, bookDesc);
			return upbook;
		}
		
		

	}

	//删除图书
	@Override
	public int deletebook(String bookname) throws TBookDetailException{
		if(bookname==null || bookname.trim().equals("")) {
			throw new TBookDetailException("请选择要删除的图书名称！");
		}
		
		TBook isTbook = tbookmapper.selectbook(bookname);
		
		if(isTbook==null) {
			throw new TBookDetailException("该要删除的图书不存在！");
		}
		
		int isdelBook = tbookmapper.deletebook(bookname);
		
		if(isdelBook<1) {
			throw new TBookDetailException("删除图书失败！");
		}
		
		return isdelBook;
	}

	//通过图书名称查询图书信息
	@Override
	public TBook selectbook(String bookname) throws TBookDetailException{
		if(bookname==null || bookname.trim().equals("")) {
			throw new TBookDetailException("请选择要查询的图书名称！");
		}
		
		TBook bookdetail = tbookmapper.selectbook(bookname);
		
		return bookdetail;
	}
	
}
