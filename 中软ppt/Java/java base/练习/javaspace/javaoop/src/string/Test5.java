package string;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String reg = "#\\{(.[^#{}])+\\}";
		//1-对正则进行编译
		Pattern p = Pattern.compile(reg);
		//2-生成Matcher比对对象
		Matcher match = p.matcher("select * from user where id=#{u.id} and pwd=#{p.id}");
		//查找能够匹配正则的部分，返回boolean值
		while(match.find()){
			//获得匹配正则的部分
			String str = match.group();
			System.out.println(str.substring(2,str.length()-1));
		}
	}

}
