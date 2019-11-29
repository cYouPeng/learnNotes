package com.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import com.entity.User;

public class UserFilter implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub

	}

	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest request = (HttpServletRequest) req;

		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("LOGIN_USER");
		
		if (user == null) {
			HttpServletResponse response = (HttpServletResponse) res;
			JSONObject json = new JSONObject();
			response.setCharacterEncoding("utf-8");
			PrintWriter out = response.getWriter();
			json.put("status", 2);
			json.put("reason","no-login");
			out.println(json.toString());
			out.close();
			return;
		} else {
			chain.doFilter(request, res);
		}

	}

	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

}
