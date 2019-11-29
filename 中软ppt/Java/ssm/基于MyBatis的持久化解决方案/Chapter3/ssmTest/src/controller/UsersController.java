package controller;

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
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import service.IUsersService;

import entity.Users;

@Controller
@SessionAttributes({"users"})
public class UsersController {
	
	//@Resource()
	@Autowired
	private IUsersService usersService;

	@RequestMapping("/login.do")
	public String login(Model model,Users users) throws Exception {
		Users usersResult = usersService.selectUsersByPass(users);
        if(usersResult!=null){
        	model.addAttribute("users", usersResult);
        	return "success";
        }else{
        	return "error";
        }
	}

	/*
	public IUsersService getUsersService() {
		return usersService;
	}

	public void setUsersService(IUsersService usersService) {
		this.usersService = usersService;
	}
	*/
}
