package string;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 输入一个字符串，判断该字符串是否为合法邮编
 * 输入一个字符串，判断其是否为合法类名
 * @author Administrator
 *
 */
public class Lianxi13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String emailReg = "^[\w.$#]+@\\w+(\\.[A-Za-z]{2,3}){1,2}$";
		
		String mailRegex = "^\\d{6}$";
		//a
		System.out.println("110000".matches(mailRegex));
		//b
		System.out.println(Pattern.matches(mailRegex, "110000"));
		//c
		Pattern p = Pattern.compile(mailRegex);
		Matcher m = p.matcher("110011");
		System.out.println(m.matches());
	}

}
