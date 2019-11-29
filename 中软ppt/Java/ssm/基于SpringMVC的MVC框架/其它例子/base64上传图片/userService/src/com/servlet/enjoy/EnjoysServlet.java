package com.servlet.enjoy;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import com.dao.EnjoyDao;
import com.entity.User;

public class EnjoysServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		JSONObject json = new JSONObject();
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("LOGIN_USER");
		EnjoyDao dao = new EnjoyDao();
		List list = dao.getEnjoyListByUser(user.getLoginId());
		if(list != null){
			json.put("status", "0");
			json.put("reason", "find-success");
			json.put("enjoys", list);
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
