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

public class UserInSessionServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		JSONObject json = new JSONObject();
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("LOGIN_USER");
		User u = user.clone();
		String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();
		u.setHeadPic(basePath+"/"+u.getHeadPic());
		json.put("user",u);
		PrintWriter out = response.getWriter();
		out.println(json.toString());
		out.close();
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
