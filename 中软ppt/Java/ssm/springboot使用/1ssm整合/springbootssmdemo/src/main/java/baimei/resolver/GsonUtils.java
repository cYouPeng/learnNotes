package baimei.resolver;

import java.util.List;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import com.google.gson.Gson;


public class GsonUtils{
	
}
//@Configuration
////@EnableWebMvc
//@SpringBootConfiguration 
//public class GsonUtils extends WebMvcConfigurationSupport {
//	final static org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(GsonUtils.class);
//	@Override
//	protected void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
//		System.out.println("gson");
//		converters
//				.removeIf(httpMessageConverter -> httpMessageConverter instanceof MappingJackson2HttpMessageConverter);
//		converters.add(new GsonHttpMessageConverter());
//		super.extendMessageConverters(converters);
//	}
	 
//}
