package exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

public class MyExceptionResolver implements HandlerExceptionResolver{

	@Override
	public ModelAndView resolveException(HttpServletRequest request,HttpServletResponse response,Object handler,Exception ex) {
		MyException me = null;
		if(ex instanceof MyException){
			me = (MyException)ex;
		}else{
			me = new MyException("未知异常！");
		}
		ModelAndView mav = new ModelAndView();
		mav.addObject("message", me.getMessage());
		mav.setViewName("error");
		return mav;
	}
}
