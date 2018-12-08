//package com.example.demo.utils;
//
//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.JSONObject;
//import com.alibaba.fastjson.serializer.SerializerFeature;
//
///*
// * SerializerFeature属性 应用
// */
//public class SerializerFeatureUtil {
//	
//	
//    /**
//     * 9:自定义
//     * 格式化输出
//     * 显示值为null的字段
//     * 将为null的字段值显示为""
//     * DisableCircularReferenceDetect:消除循环引用
//     */
////	public static void showJsonBySelf() {
////		JSON.toJSONString(word, SerializerFeature.PrettyFormat,
////                SerializerFeature.WriteMapNullValue, 
////                SerializerFeature.WriteNullStringAsEmpty,
////                SerializerFeature.DisableCircularReferenceDetect,
////                SerializerFeature.WriteNullListAsEmpty);
////    }
//
//	/**
//     * 8:
//     * 将对象转为array输出
//     */
//	public static <T>void beanToArray(T data) {
//		JSON.toJSONString(data, SerializerFeature.BeanToArray);
//	}
//	
//    /**
//     * 7:
//     * WriteDateUseDateFormat:全局修改日期格式,默认为false。
//     */
//	public static <T>void writeDateUseDateFormat(T data) {
//		JSON.DEFFAULT_DATE_FORMAT = "yyyy-MM-dd";
//		JSON.toJSONString(data, SerializerFeature.WriteDateUseDateFormat);
//	}
//	
//    /**
//     * 6:
//     * PrettyFormat
//     */
//	public static <T>void prettyFormat(T data) {
//		JSON.toJSONString(data, SerializerFeature.PrettyFormat);
//	}
//	
//	/**
//     * SortField:按字段名称排序后输出。默认为false
//     * 这里使用的是fastjson：为了更好使用sort field martch优化算法提升parser的性能，fastjson序列化的时候，
//     * 缺省把SerializerFeature.SortField特性打开了。
//     * 反序列化的时候也缺省把SortFeidFastMatch的选项打开了。
//     * 这样，如果你用fastjson序列化的文本，输出的结果是按照fieldName排序输出的，parser时也能利用这个顺序进行优化读取。
//     * 这种情况下，parser能够获得非常好的性能。
//     */
//	public static <T>void sortField(T data) {
//		JSON.toJSONString(data, SerializerFeature.SortField);
//	}
//	
//	/**
//     *  5:
//     *  WriteNullStringAsEmpty:字符类型字段如果为null,输出为"",而非null
//     *  需要配合WriteMapNullValue使用，现将null输出
//     */
//	public static <T>void writeNullStringAsEmpty(T data) {
//		System.out.println("设置WriteMapNullValue后：");
//        JSONObject.toJSONString(data, SerializerFeature.WriteMapNullValue);
//        System.out.println("设置WriteMapNullValue、WriteNullStringAsEmpty后：");
//        JSONObject.toJSONString(data, SerializerFeature.WriteMapNullValue, SerializerFeature.WriteNullStringAsEmpty);
//
//	}
//	
//	/**
//     * 4:
//     * WriteNullListAsEmpty:List字段如果为null,输出为[],而非null
//     * 需要配合WriteMapNullValue使用，现将null输出
//     */
//	public static <T>void writeNullListAsEmpty(T data) {
//		 System.out.println("设置WriteNullListAsEmpty后：");
//	     JSONObject.toJSONString(data, SerializerFeature.WriteMapNullValue, SerializerFeature.WriteNullListAsEmpty);
//	}
//	
//    /**
//     * 3:
//     * UseISO8601DateFormat:Date使用ISO8601格式输出，默认为false
//     */
//	public static <T>void useISO8601DateFormat(T data) {
//		System.out.println("设置UseISO8601DateFormat后：");
//        JSONObject.toJSONString(data, SerializerFeature.UseISO8601DateFormat);
//	}
//	
//    /**
//     * 2:
//     * WriteMapNullValue:是否输出值为null的字段,默认为false
//     * @return 
//     */
//	public static <T> String writeMapNullValue(T data) {
//		System.out.println("设置WriteMapNullValue后：");
////        JSONObject.toJSONString(data, SerializerFeature.WriteMapNullValue);
//		return JSONObject.toJSONString(data, SerializerFeature.WriteMapNullValue);
//	}
//	
//    /**
//     * 1:
//     * UseSingleQuotes:使用单引号而不是双引号,默认为false
//     */
//	public static <T>void useSingleQuotes(T data) {
//		System.out.println("设置useSingleQuotes后：");
//        JSONObject.toJSONString(data, SerializerFeature.UseSingleQuotes);
//	}
//	
//}
