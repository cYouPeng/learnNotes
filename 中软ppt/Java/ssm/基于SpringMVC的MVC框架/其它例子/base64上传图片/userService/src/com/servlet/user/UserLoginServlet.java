package com.servlet.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import com.dao.UserDao;
import com.entity.User;

public class UserLoginServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		JSONObject json = new JSONObject();
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("uid");
		String pwd = request.getParameter("upwd");
		UserDao dao = new UserDao();
		User u = dao.getUserById(id);
		System.out.println("===login:"+id);
		if(u !=null && u.getLoginId().equals(id) && u.getLoginPwd().equals(pwd)){
			HttpSession session = request.getSession();
			u.setLoginPwd(null);
			
			session.setAttribute("LOGIN_USER", u);
			json.put("status", "0");
			json.put("reason", "login-success");
		}else{
			json.put("status", "1");
			json.put("reason","server-error");
		}
		
		PrintWriter out = response.getWriter();
		out.println(json.toString());
		out.close();
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
