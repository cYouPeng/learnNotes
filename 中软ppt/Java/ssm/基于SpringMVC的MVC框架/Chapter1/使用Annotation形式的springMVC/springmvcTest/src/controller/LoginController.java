package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController{

	@RequestMapping("login.do")
	public ModelAndView login(String username,String password) throws Exception {
        ModelAndView mav = new ModelAndView();
        if(username.equals("test")&&password.equals("111")){
            //相当于request.setAttribute();
            mav.addObject("username", username);
            //指定视图
            mav.setViewName("success");
        }else{
            mav.setViewName("error");
        }
        return mav;
	}
}
