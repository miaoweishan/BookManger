package com.example.demo.dao;

import java.util.Date;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonInclude;

@Table(name = "t_book")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TBook {
    @Id
    private Long id;

    /**
     * 图书名称
     */
    @Column(name = "bookName")
    private String bookname;

    /**
     * 作者
     */
    private String author;

    /**
     * 性别
     */
    private String sex;

    /**
     * 价格
     */
    private Long price;

    /**
     * 图书类别id
     */
    @Column(name = "bookTypeId")
    private Integer booktypeid;

    /**
     * 图书描述
     */
    @Column(name = "bookDesc")
    private String bookdesc;

    /**
     * 0：未删除 1：删除
     */
    private Boolean isdelete;

    /**
     * 创建时间
     */
    @Column(name = "createDate")
    private Date createdate;

    /**
     * 修改时间
     */
    @Column(name = "modifyDate")
    private Date modifydate;

    /*
     * 图书类别
     */
    private TBooktype tbooktype;
    
    public TBooktype getTbooktype() {
		return tbooktype;
	}

	public void setTbooktype(TBooktype tbooktype) {
		this.tbooktype = tbooktype;
	}

	/**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取图书名称
     *
     * @return bookName - 图书名称
     */
    public String getBookname() {
        return bookname;
    }

    /**
     * 设置图书名称
     *
     * @param bookname 图书名称
     */
    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    /**
     * 获取作者
     *
     * @return author - 作者
     */
    public String getAuthor() {
        return author;
    }

    /**
     * 设置作者
     *
     * @param author 作者
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * 获取性别
     *
     * @return sex - 性别
     */
    public String getSex() {
        return sex;
    }

    /**
     * 设置性别
     *
     * @param sex 性别
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * 获取价格
     *
     * @return price - 价格
     */
    public Long getPrice() {
        return price;
    }

    /**
     * 设置价格
     *
     * @param price 价格
     */
    public void setPrice(Long price) {
        this.price = price;
    }

    /**
     * 获取图书类别id
     *
     * @return bookTypeId - 图书类别id
     */
    public Integer getBooktypeid() {
        return booktypeid;
    }

    /**
     * 设置图书类别id
     *
     * @param booktypeid 图书类别id
     */
    public void setBooktypeid(Integer booktypeid) {
        this.booktypeid = booktypeid;
    }

    /**
     * 获取图书描述
     *
     * @return bookDesc - 图书描述
     */
    public String getBookdesc() {
        return bookdesc;
    }

    /**
     * 设置图书描述
     *
     * @param bookdesc 图书描述
     */
    public void setBookdesc(String bookdesc) {
        this.bookdesc = bookdesc;
    }

    /**
     * 获取0：未删除 1：删除
     *
     * @return isdelete - 0：未删除 1：删除
     */
    public Boolean getIsdelete() {
        return isdelete;
    }

    /**
     * 设置0：未删除 1：删除
     *
     * @param isdelete 0：未删除 1：删除
     */
    public void setIsdelete(Boolean isdelete) {
        this.isdelete = isdelete;
    }

    /**
     * 获取创建时间
     *
     * @return createDate - 创建时间
     */
    public Date getCreatedate() {
        return createdate;
    }

    /**
     * 设置创建时间
     *
     * @param createdate 创建时间
     */
    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    /**
     * 获取修改时间
     *
     * @return modifyDate - 修改时间
     */
    public Date getModifydate() {
        return modifydate;
    }

    /**
     * 设置修改时间
     *
     * @param modifydate 修改时间
     */
    public void setModifydate(Date modifydate) {
        this.modifydate = modifydate;
    }
}