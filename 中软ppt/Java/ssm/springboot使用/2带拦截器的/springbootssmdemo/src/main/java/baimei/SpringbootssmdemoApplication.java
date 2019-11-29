package baimei;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import baimei.resolver.GsonUtils;

@RestController
@SpringBootApplication
@MapperScan("baimei.mapper")
public class SpringbootssmdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootssmdemoApplication.class, args);
	}

	@RequestMapping("/")
	public String test() {
		return "hello";
	}
}
