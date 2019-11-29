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

public class UserModifyPwdServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		JSONObject json = new JSONObject();
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("LOGIN_USER");
		String oldPwd = request.getParameter("oldPwd");
		String newPwd = request.getParameter("newPwd");
		
		UserDao dao = new UserDao();
		User u = dao.getUserById(user.getLoginId());
		if(u.getLoginPwd().equals(oldPwd)){
			u.setLoginPwd(newPwd);
			if(dao.updatePwd(u)>0){
				
				session.invalidate();
				json.put("status", 0);
				json.put("reason", "update-pwd-success");
			}else{
				json.put("status", 1);
				json.put("reason","server-error");
			}
		}else{
			json.put("status", 3);
			json.put("reason","oldpwd-error");
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
