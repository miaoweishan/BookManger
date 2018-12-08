package com.example.demo.dto;

/*
 * 封装接口返回的结果
 */
public class BookMangerResult<T> {
	private boolean success;
	
	private T data;
	
	private Object message;
	

	public BookMangerResult(boolean status,T booktypebyall,String message){
		this.success=status;
		this.data=booktypebyall;
		this.message=message;
	}
	
	public BookMangerResult(boolean status,Object message){
		this.success=status;
		this.message=message;
	}
	
	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public Object getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
