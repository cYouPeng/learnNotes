package com.chinasoft.news.controller;

import java.io.PrintWriter;
import java.util.Arrays;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.chinasoft.news.entity.Users;
import com.chinasoft.news.service.IUsersService;

@Controller
@RequestMapping("/users")
//@SessionAttributes({"users"})
public class UsersController {
	
	@Autowired
	private IUsersService usersService;

	@ResponseBody
	@RequestMapping("/selectUsersByPass.do")
	public Users login(Model model,Users users,HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		Users usersResult = usersService.selectUsersByPass(users);
        if(usersResult!=null){
        	/*
        	 * 登陆时不能使用model.addAttribute("users", usersResult);向session中存储数据。
        	 * 原因：
        	 * Spring框架会在调用完Controller之后、渲染View之前检查Model的信息，
        	 * 并把@SessionAttributes()注释标明的属性加入session中。
        	 * 所以，当Controller已经执行完毕并response后，才会创建Session并存储数据，
        	 * 但这时服务器已经将数据发送到客户端了，也就无法发送Session ID 了。
        	 * 因此一定要保证在response输出响应前获取session。
        	 */
        	//model.addAttribute("users", usersResult);
        	session.setAttribute("users", usersResult);
        	return usersResult;
        }else{
        	return null;
        }
	}
	
	@ResponseBody
	@RequestMapping("/manager/selectUsersById.do")
	public Users login(int userId) throws Exception {
		Users users = usersService.selectUsersById(userId);
        return users;
	}
	
	@ResponseBody
	@RequestMapping("/authorization.do")
	public Users authorization(HttpServletRequest request) throws Exception {
		System.out.println("验证登陆......");
		return (Users)request.getSession().getAttribute("users");
	}
}
