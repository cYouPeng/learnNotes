package controller;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import entity.Users;
import exception.MyException;

@Controller
@RequestMapping("/ssm")
@SessionAttributes({"users"})
public class LoginController {

	//@RequestMapping("/login.do")
	@RequestMapping(value="/login.do",method={RequestMethod.GET,RequestMethod.POST}) 
	public String login(Model model,Users users) throws Exception {
        if(users.getUsername().equals("test")&&users.getPassword().equals("111")){
        	model.addAttribute("users", users);
        	return "success";
        }else{
        	throw new MyException("用户名或密码错误");
        }
	}
}
