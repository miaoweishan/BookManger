package com.example.demo.dao;

import java.util.Date;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonInclude;

@Table(name = "t_user")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TUser {
    @Id
    private Long id;

    /**
     * 用户名
     */
    @Column(name = "userName")
    private String username;

    /**
     * 密码
     */
    private String password;

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
     * 获取用户名
     *
     * @return userName - 用户名
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置用户名
     *
     * @param username 用户名
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取密码
     *
     * @return password - 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置密码
     *
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password;
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