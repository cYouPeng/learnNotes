package com.chinasoft.news.interceptor;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.chinasoft.news.entity.Users;

public class LoginInterceptor extends HandlerInterceptorAdapter{

    public boolean preHandle(HttpServletRequest request,HttpServletResponse response,Object handler) throws Exception {    
    	System.out.println("进入权限验证拦截器......");
    	Users users =  (Users)request.getSession().getAttribute("users");   
    	/*
        if(users==null){
        	//如果是ajax提交，请求头都会多一个x-requested-with属性，属性值是：XMLHttpRequest
        	if(request.getHeader("x-requested-with")!=null&&request.getHeader("x-requested-with").equalsIgnoreCase("XMLHttpRequest")){ 
        		PrintWriter out = response.getWriter();  
                out.print("loseSession");
                out.flush();
        	}else{
        		request.getRequestDispatcher("/admin/login.html").forward(request, response);    
        	}
        	return false;
        }
        return true;
        */
    	if(request.getHeader("x-requested-with")!=null&&request.getHeader("x-requested-with").equalsIgnoreCase("XMLHttpRequest")){ 
    		PrintWriter out = response.getWriter();  
            out.print("loseSession");
            out.flush();
    	}else{
    		request.getRequestDispatcher("/admin/login.html").forward(request, response);    
    	}
    	return false;
    }    
      
    public void postHandle(HttpServletRequest request,HttpServletResponse response,Object handler,ModelAndView modelAndView)throws Exception{}    
    
    public void afterCompletion(HttpServletRequest request,HttpServletResponse response,Object handler, Exception ex)throws Exception{}    
}
