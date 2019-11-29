package baimei.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import baimei.interceptor.LoginTimeInterceptor;

/**
 * 配置拦截器
 * @author 白眉出品
 */

@Configuration
public class InterceptorConfig extends WebMvcConfigurerAdapter{
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		//这里可以添加多个拦截器
		registry.addInterceptor(new LoginTimeInterceptor()).addPathPatterns("/**");
		super.addInterceptors(registry);
	}
}
