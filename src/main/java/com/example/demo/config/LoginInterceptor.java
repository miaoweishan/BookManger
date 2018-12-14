package com.example.demo.config;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/** 
 * 登录验证拦截 
 * 实现了HandlerInterceptor类，由它来拦截并过滤到来的每一个请求；
 * 它的三个方法能分别作用于每个请求的不同生命周期，你可以根据自己的需要来加入相应的处理逻辑；
 */ 
@Controller
@Component
public class LoginInterceptor extends HandlerInterceptorAdapter{
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
    /*@Autowired 
    UserService userService;*/  
      
    /*@Value("${IGNORE_LOGIN}") 
    Boolean IGNORE_LOGIN;*/  
	
    /**
     * 在请求被处理之前调用
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override  
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)  
            throws Exception {  
    	/*
    	 * request.getRequestURL() 返回全路径
		   request.getRequestURI() 返回除去host（域名或者ip）部分的路径
		   request.getContextPath() 返回工程名部分，如果工程映射为/，此处返回则为空
		   request.getServletPath() 返回除去host和工程名部分的路径
    	 */
        String basePath = request.getContextPath();  
        String path = request.getRequestURI();  
        logger.info("basePath:"+basePath);  
        logger.info("path:"+path);  

        if(!doLoginInterceptor(path, basePath) ){//是否进行登陆拦截  
        	logger.info("======是否进行登陆拦截=====:"+"不拦截");
            return true;  
        }
        
        //如果登录了，会把用户信息存进session  
        HttpSession session = request.getSession();
        String users =  (String) session.getAttribute("userid");  
        logger.info("=====userid===:"+users);
        
        int sessiontime = request.getSession().getMaxInactiveInterval(); //查看session 的有效时间
        
        //开发环节的设置，不登录的情况下自动登录  
        /*if(userInfo==null && IGNORE_LOGIN){ 
            userInfo = sysUserService.getUserInfoByUserID(2); 
            session.setAttribute(Constants.SessionKey.USER, userInfo); 
        }*/  
        
        if(users==null){  
        	logger.info("尚未登录，跳转到登录界面"); 
            response.sendRedirect(request.getContextPath()+"/userLogin"); 
              
            String requestType = request.getHeader("X-Requested-With");  
            logger.info("====requestType:====="+requestType);  
            if(requestType!=null && requestType.equals("XMLHttpRequest")){  
                response.setHeader("sessionstatus","timeout");  
//              response.setHeader("basePath",request.getContextPath());  
                response.getWriter().print("LoginTimeout");  
                return false;  
            } else {  
            	logger.info("尚未登录，跳转到登录界面");  
//                response.sendRedirect(request.getContextPath()+"userLogin");
            }  
            return false;  
        }  
//      log.info("用户已登录,userName:"+userInfo.getSysUser().getUserName());  
        return true;  
    }
    
    /**
     * 在请求被处理后，视图渲染之前调用
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
 
    }
    
    /**
     * 在整个请求结束后调用
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
 
    }

      
    /** 
     * 是否进行登陆过滤 
     * @param path 
     * @param basePath 
     * @return 
     */  
    private boolean doLoginInterceptor(String path,String basePath){  
        path = path.substring(basePath.length());  
        Set<String> notLoginPaths = new HashSet<>();  
        //设置不进行登录拦截的路径：登录注册和验证码  
        notLoginPaths.add("/bookmanger/userRegister.json");  //注册
        notLoginPaths.add("/bookmanger/userLogin.json");  //登录
        notLoginPaths.add("/demo/error.json");  //错误页面
        logger.info("====请求的path===="+path);
        if(notLoginPaths.contains(path)) return false;  
        return true;  
    }  

}
