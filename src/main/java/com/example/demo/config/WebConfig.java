package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
/*
 * 继承自WebMvcConfigurerAdapter类，负责注册并生效我们自己定义的拦截器配置；
 */
@Configuration
public class WebConfig extends WebMvcConfigurationSupport{
  
    @Autowired  
    LoginInterceptor loginInterceptor;
  
    /** 
     * 不需要登录拦截的url:登录、注册 
     */  
    final String[] notLoginInterceptPaths = {"/userRegister","/userLogin","/error"};
  
    @Override  
    public void addInterceptors(InterceptorRegistry registry) {  
        // 日志拦截器  
        //registry.addInterceptor(logInterceptor).addPathPatterns("/**");  
        // 注册拦截器、拦截路径、排除路径  
        registry.addInterceptor(loginInterceptor).addPathPatterns("/**").excludePathPatterns(notLoginInterceptPaths);  
    }  
  
    @Override  
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {  
        configurer.enable();  
    }  
  
    @Bean  // 配置JSP视图解析器
    public InternalResourceViewResolver viewResolver() {
    	//视图解析器
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();  
        resolver.setPrefix("/demo/");  		//路径的前缀
        resolver.setSuffix(".json");  		//路径的后置
        resolver.setViewClass(JstlView.class);  
        return resolver;  
    }  
  
    @Override  
    public void addViewControllers(ViewControllerRegistry registry) {  
  
    }  
}
