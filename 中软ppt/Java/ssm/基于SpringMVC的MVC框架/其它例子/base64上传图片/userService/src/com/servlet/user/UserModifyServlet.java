package com.servlet.user;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sun.misc.BASE64Decoder;

import net.sf.json.JSONObject;

import com.dao.UserDao;
import com.entity.User;

public class UserModifyServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		JSONObject json = new JSONObject();
		request.setCharacterEncoding("utf-8");
		String nickName = request.getParameter("uname");
		String pic = request.getParameter("hpicName");
		String picName = null;
		if(pic!=null&&!pic.trim().equals("")){
			String picStr = request.getParameter("hpicStr");
			
			BASE64Decoder decoder = new BASE64Decoder();
			
			try {
				// Base64½âÂë
				byte[] b = decoder.decodeBuffer(picStr);
				picName = "userHeadPic/"+new Date().getTime()+pic.substring(pic.lastIndexOf("."));
				String imgFilePath = request.getRealPath("/")+picName;
				OutputStream out = new FileOutputStream(imgFilePath);
				out.write(b);
				out.flush();
				out.close();
				json.put("uploadPic", "success");
			} catch (Exception e) {
				json.put("uploadPic", "error");
			}
		}
		HttpSession session = request.getSession();
		User u = (User)session.getAttribute("LOGIN_USER");
		User user = new User(u.getLoginId(),null,nickName,picName);
		UserDao dao = new UserDao();
		if(dao.updateUser(user)>0){
			session.setAttribute("LOGIN_USER", user);
			json.put("status", 0);
			json.put("reason", "update-user-success");
		}else{
			json.put("status", 1);
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
