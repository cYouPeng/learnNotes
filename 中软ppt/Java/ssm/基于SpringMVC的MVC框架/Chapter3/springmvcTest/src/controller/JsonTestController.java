package controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import entity.Users;
import exception.MyException;

@Controller
@RequestMapping("/ssm")
public class JsonTestController {

	@ResponseBody
	@RequestMapping(value="/json.do/{username}/{password}")
	public Map login(@PathVariable("username") String username,@PathVariable("password") String password) throws Exception {
		System.out.println(username + "," + password);
		Map map = new HashMap();
		Users users1 = new Users();
        users1.setUserId(1);
        users1.setUsername("张三");
        users1.setPassword("11111");
        Users users2 = new Users();
        users2.setUserId(2);
        users2.setUsername("李四");
        users2.setPassword("22222");
        map.put("aaa",users1);
        map.put("bbb",users2);
        return map;
	}
}
