package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class LoginController implements Controller{

	public ModelAndView handleRequest(HttpServletRequest request,HttpServletResponse response) throws Exception {
		String username = request.getParameter("username");
        String password = request.getParameter("password");
        ModelAndView mav = new ModelAndView();
        if(username.equals("test")&&password.equals("111")){
            //相当于request.setAttribute();
            mav.addObject("username", "张三");
            //指定视图
            mav.setViewName("/success.jsp");
        }else{
            mav.setViewName("/error.jsp");
        }
        return mav;
	}
}
