package com.example.demo.dto;

public class BookMangerExecutionRsp {
	private int status;
	
	private String msg;
	
	private String username;

	public BookMangerExecutionRsp(String username,String msg) {
		this.username=username;
		this.msg=msg;
	}
	
	@Override
	public String toString() {
		return "BookMangerExecutionRsp [status=" + status + ", msg=" + msg + ", username=" + username + "]";
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
}
