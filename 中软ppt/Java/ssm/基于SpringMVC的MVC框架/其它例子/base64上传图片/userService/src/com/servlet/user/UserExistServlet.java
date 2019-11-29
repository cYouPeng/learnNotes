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

public class UserExistServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		JSONObject json = new JSONObject();
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("uid");
		
		UserDao dao = new UserDao();
		System.out.println("+++exist"+id);
		switch(dao.findUserId(id)){
		case -1:
			json.put("status", "1");
			json.put("reason","server-error");
			break;
		case 1:
			json.put("status", "0");
			json.put("exist", true);
			json.put("reason", "user-id-exist");
			break;
		case 2:
			json.put("status", "0");
			json.put("exist", false);
			json.put("reason", "user-id-unexist");
			break;
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
