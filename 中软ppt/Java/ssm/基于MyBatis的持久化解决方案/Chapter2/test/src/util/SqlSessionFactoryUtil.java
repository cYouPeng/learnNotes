package util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionFactoryUtil {
	
	public static SqlSessionFactory sqlSessionFactory = null;

	private SqlSessionFactoryUtil(){}
	
	public static SqlSessionFactory getSqlSessionFactory(){
		if(sqlSessionFactory==null){
			try {
				InputStream input = Resources.getResourceAsStream("SqlMapConfig.xml");
				sqlSessionFactory = new SqlSessionFactoryBuilder().build(input);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return sqlSessionFactory;
	}
}
