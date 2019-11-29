package baimei.interceptor;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * 拦截器的使用
 * 
 * @author 白眉出品
 *
 */
public class LoginTimeInterceptor implements HandlerInterceptor {

	// 在控制器执行前调用
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("执行preHandle方法-->01");
		Calendar cal = Calendar.getInstance();
		int hour = cal.get(Calendar.HOUR_OF_DAY);
		System.out.println("当前时间："+hour);
		if (hour < 20)
			return true; // 通过拦截器，继续执行请求
		else {
			return false; // 没有通过拦截器，返回登录页面
		}

	}

	// 在后端控制器执行后调用
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

	}

	// 整个请求执行完成后调用
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	}
}
