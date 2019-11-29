package string;

import java.util.regex.Pattern;

public class Test4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] strArr = {"a","b","c"};
		System.out.println(String.join(",", strArr));
		
		String mailRegex = "^\\d{6}$";
		System.out.println(Pattern.matches(mailRegex, "110000"));
		System.out.println("110000".matches(mailRegex));
		
//		Matcher类提供的方法
//		String类提供的方法
		String str = "hello1world22!!!";
		String[] arr = str.split("\\d+");
		
		for(String s : arr){
			System.out.println(s);
		}
		
		str = "abc bcd	faf\nfdafdsa";
		System.out.println(str);
		String newStr = str.replaceFirst("\\s", "");
		System.out.println(newStr);
		
//		String idRegex = "^\\d{17}[\\dXx]$";
		String idRegex = "^\\d{6}(18|19|20)\\d{2}([0][1-9]|[1][0-2])[0-3][0-9]\\d{3}[\\dXx]$";
		System.out.println(Pattern.matches(idRegex, "12345620201006567X"));
		
		
//		String classRegex = "^[\w[$]]+$";
		String classRegex = "^([A-Z][a-z]+)+([$]\\d+)*$";
		System.out.println(Pattern.matches(classRegex, "AbCd"));
	}

}
