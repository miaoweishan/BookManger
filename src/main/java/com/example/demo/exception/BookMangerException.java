package com.example.demo.exception;
/*
 * 图书管理相关异常
 */
public class BookMangerException extends RuntimeException{
	public BookMangerException(String message) {
		super(message);
	}
	
	public BookMangerException(String message, Throwable cause) {
		super(message,cause);
	}

}
