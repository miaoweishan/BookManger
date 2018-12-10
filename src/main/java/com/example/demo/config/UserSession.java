package com.example.demo.config;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/** 
 * 登录验证拦截 
 * 
 */ 
@Controller
@Component
public class UserSession extends HandlerInterceptorAdapter{
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
    /*@Autowired 
    UserService userService;*/  
      
    /*@Value("${IGNORE_LOGIN}") 
    Boolean IGNORE_LOGIN;*/  
	
    @Override  
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)  
            throws Exception {  
        String basePath = request.getContextPath();  
        String path = request.getRequestURI();  
//      log.info("basePath:"+basePath);  
//      log.info("path:"+path);  
          
        if(!doLoginInterceptor(path, basePath) ){//是否进行登陆拦截  
            return true;  
        }  
          
//      HttpSession session = request.getSession();  
//      int userID = 2;  
//      UserInfo userInfo = sysUserService.getUserInfoByUserID(userID);  
//      System.out.println(JsonUtil.toJson(userInfo));  
//      session.setAttribute(Constants.SessionKey.USER, userInfo);  
          
        //如果登录了，会把用户信息存进session  
        HttpSession session = request.getSession();  
        List<User> users =  (List<User>) session.getAttribute("userList");  
        /*User userInfo = new User(); 
        userInfo.setId(users.get(0).getId()); 
        userInfo.setName(users.get(0).getName()); 
        userInfo.setPassword(users.get(0).getPassword());*/  
        //开发环节的设置，不登录的情况下自动登录  
        /*if(userInfo==null && IGNORE_LOGIN){ 
            userInfo = sysUserService.getUserInfoByUserID(2); 
            session.setAttribute(Constants.SessionKey.USER, userInfo); 
        }*/  
        if(users==null){  
            /*log.info("尚未登录，跳转到登录界面"); 
            response.sendRedirect(request.getContextPath()+"signin");*/  
              
            String requestType = request.getHeader("X-Requested-With");  
//          System.out.println(requestType);  
            if(requestType!=null && requestType.equals("XMLHttpRequest")){  
                response.setHeader("sessionstatus","timeout");  
//              response.setHeader("basePath",request.getContextPath());  
                response.getWriter().print("LoginTimeout");  
                return false;  
            } else {  
            	logger.info("尚未登录，跳转到登录界面");  
                response.sendRedirect(request.getContextPath()+"signin");  
            }  
            return false;  
        }  
//      log.info("用户已登录,userName:"+userInfo.getSysUser().getUserName());  
        return true;  
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
        //notLoginPaths.add("/");  
        notLoginPaths.add("/index");  
        notLoginPaths.add("/signin");  
        notLoginPaths.add("/login");  
        notLoginPaths.add("/register");  
        notLoginPaths.add("/kaptcha.jpg");  
        notLoginPaths.add("/kaptcha");  
        //notLoginPaths.add("/sys/logout");  
        //notLoginPaths.add("/loginTimeout");  
          
        if(notLoginPaths.contains(path)) return false;  
        return true;  
    }  

}
