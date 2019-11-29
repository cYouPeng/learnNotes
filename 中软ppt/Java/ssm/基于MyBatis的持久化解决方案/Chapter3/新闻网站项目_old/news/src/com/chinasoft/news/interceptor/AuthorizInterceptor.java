package com.chinasoft.news.interceptor;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.chinasoft.news.entity.Users;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;;

public class AuthorizInterceptor extends HandlerInterceptorAdapter{
  
    @Override    
    public boolean preHandle(HttpServletRequest request,HttpServletResponse response,Object handler) throws Exception {    
    	Users users =  (Users)request.getSession().getAttribute("users");   
        if(users == null){   
            request.getRequestDispatcher("/admin/login.jsp").forward(request, response);  
            return false;  
        }else{
            return true;     
    	}
    }    
   
    public void postHandle(HttpServletRequest request,HttpServletResponse response,Object handler,ModelAndView modelAndView)throws Exception{}    
  
    public void afterCompletion(HttpServletRequest request,HttpServletResponse response,Object handler, Exception ex)throws Exception{}    
}
