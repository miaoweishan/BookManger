package com.example.demo.utils;

import java.lang.annotation.*;

/**
 * Created by huguoju on 2016/12/30.
 * 在类或方法上添加@Auth就验证登录
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Auth {
	
}
