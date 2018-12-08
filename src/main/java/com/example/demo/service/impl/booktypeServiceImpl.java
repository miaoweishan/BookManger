package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.TBooktype;
import com.example.demo.exception.TBookTypeException;
import com.example.demo.mapper.TBooktypeMapper;
import com.example.demo.service.booktypeService;

/*
 * 图书类别管理
 */

@Service
public class booktypeServiceImpl implements booktypeService{

	@Autowired
	private TBooktypeMapper tbooktypemapper;
	/*
	 * 查看所有图书类别
	 * @see com.example.demo.service.booktypeService#selectbooktype()
	 */
	@Override
	public List<TBooktype> selectbooktype() throws TBookTypeException{
		List<TBooktype> booktypeall = tbooktypemapper.selectbooktype();
	
		if(booktypeall==null) {
			throw new TBookTypeException("没有可选择的图书类别！");
		}
		return booktypeall;
		
	}

	/*
	 * 添加图书类别
	 * @see com.example.demo.service.booktypeService#insertbooktype(java.lang.String, java.lang.String)
	 */
	@Override
	public int insertbooktype(String booktpyename, String booktpyedesc) throws TBookTypeException{
		
		if(booktpyename==null || booktpyename.trim().equals("")) {
			throw new TBookTypeException("图书类别名称不能为空！");
		}
		
		
		TBooktype booktypedetail = tbooktypemapper.selectbooktypebybtname(booktpyename);
		if(booktypedetail!=null || booktypedetail.getId()!=0) {
			throw new TBookTypeException("该图书类别已存在！");
		}
		
		int isinsert = tbooktypemapper.insertbooktype(booktpyename, booktpyedesc);
		if(isinsert==0) {
			throw new TBookTypeException("添加图书类别失败！");
		}
		return isinsert;
		
	}

	/*
	 * 删除图书类别
	 * @see com.example.demo.service.booktypeService#deletebooktype(java.lang.String)
	 */
	@Override
	public int deletebooktype(String booktpyename) throws TBookTypeException{
		
		if(booktpyename==null || booktpyename.trim().equals("")) {
			throw new TBookTypeException("请选择要删除的图书类别！");
		}
		
		TBooktype booktypedetail = tbooktypemapper.selectbooktypebybtname(booktpyename);
		if(booktypedetail==null || booktypedetail.equals("")) {
			throw new TBookTypeException("该图书类别不存在！");
		}

		int isdelete = tbooktypemapper.deletebooktype(booktpyename); 
		
		if(isdelete==0) {
			throw new TBookTypeException("删除图书类别失败！");
		}
		return isdelete;

	}

	/*
	 * 通过图书类别名称查询图书类别信息
	 * @see com.example.demo.service.booktypeService#deletebooktype(java.lang.String)
	 */
	@Override
	public TBooktype selectbooktypebybtname(String booktpyename) throws TBookTypeException {
		if(booktpyename==null || booktpyename.trim().equals("")) {
			throw new TBookTypeException("请填写图书类别名称！");
		}
		
		TBooktype booktypedetail = tbooktypemapper.selectbooktypebybtname(booktpyename);
		
		if(booktypedetail==null || booktypedetail.equals("")) {
			throw new TBookTypeException("没有该图书类别！");
		}
			
		return booktypedetail;

	}

}
