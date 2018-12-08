package com.example.demo.dao;

import java.util.Date;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonInclude;

@Table(name = "t_booktype")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TBooktype {
    @Id
    private Long id;

    /**
     * 图书类别
     */
    @Column(name = "bookTpyeName")
    private String booktpyename;

    /**
     * 图书类别描述
     */
    @Column(name = "bookTpyeDesc")
    private String booktpyedesc;

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
     * 获取图书类别
     *
     * @return bookTpyeName - 图书类别
     */
    public String getBooktpyename() {
        return booktpyename;
    }

    /**
     * 设置图书类别
     *
     * @param booktpyename 图书类别
     */
    public void setBooktpyename(String booktpyename) {
        this.booktpyename = booktpyename;
    }

    /**
     * 获取图书类别描述
     *
     * @return bookTpyeDesc - 图书类别描述
     */
    public String getBooktpyedesc() {
        return booktpyedesc;
    }

    /**
     * 设置图书类别描述
     *
     * @param booktpyedesc 图书类别描述
     */
    public void setBooktpyedesc(String booktpyedesc) {
        this.booktpyedesc = booktpyedesc;
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