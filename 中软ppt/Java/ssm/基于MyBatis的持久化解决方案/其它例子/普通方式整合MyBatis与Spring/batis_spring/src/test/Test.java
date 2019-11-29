package test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.FirstTitleDao;
import entity.FirstTitle;

public class Test {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		FirstTitleDao dao = (FirstTitleDao)context.getBean("firstTitleDaoImpl");
		List<FirstTitle> firstList = dao.selectFirstTitleAll();
		for(FirstTitle ft : firstList){
			System.out.println(ft.getFid() + "\t" + ft.getTitleName() + "\t" + ft.getCreator() + "\t" + ft.getCreateTime());
		}
	}
}
