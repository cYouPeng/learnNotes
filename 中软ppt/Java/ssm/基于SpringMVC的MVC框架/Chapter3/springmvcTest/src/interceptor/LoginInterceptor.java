package interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import entity.Users;

public class LoginInterceptor extends HandlerInterceptorAdapter{
    //在业务处理器处理请求之前被调用  
    public boolean preHandle(HttpServletRequest request,HttpServletResponse   response,Object handler) throws Exception {    
        Users users =  (Users)request.getSession().getAttribute("users");   
        if(users == null){   
            request.getRequestDispatcher("/login.jsp").forward(request, response);  
            return false;  
        }else{
            return true;
        }
    }    
    
    //在业务处理器处理请求执行完成后,生成视图之前执行的动作     
    public void postHandle(HttpServletRequest request,HttpServletResponse response,Object handler,ModelAndView modelAndView)throws Exception{}    
    
    //在DispatcherServlet完全处理完请求后被调用,可用于清理资源等       
    public void afterCompletion(HttpServletRequest request,HttpServletResponse response,Object handler, Exception ex)throws Exception{}    
}

