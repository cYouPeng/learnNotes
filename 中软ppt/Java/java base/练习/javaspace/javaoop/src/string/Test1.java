package string;

public class Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
//		String s = "hello";
//		s = "你好";
//		String str = new String("hello");
//		String str2 = new String(new char[]{'h','e','l','l','o'});
//		
//		char[] arr = new char[]{'h','e','l','l','o'};
//		System.out.println(s);
//		System.out.println(arr);
		
//		String s = "hello";
//		s = "你好";
//		System.out.println(s.length());
//		System.out.println("hello".length());
//		s = "";
//		System.out.println(s.isEmpty());
//		
//		s = "Hello";
//		System.out.println(s.toUpperCase());
//		
//		System.out.println(s.toLowerCase());
//		System.out.println(s);
//		s = s.toUpperCase();
//		System.out.println(s);
//		
//		s = "      world       ";
//		System.out.println(s.trim());
//		
//		s = "lisi";
//		//s = null;
//		System.out.println("lisi".equals(s));
//		
//		System.out.println(s.equals("lisi"));
//		System.out.println("abc==ABC:"+("abc".equalsIgnoreCase("ABC")));

		String s = "hello";
		for(int i=0; i<s.length();i++){
			System.out.println(s.charAt(i));//用位置找字符
		}
		
		s = "abcabdabc";
		System.out.println(s.indexOf("xx"));
		System.out.println(s.lastIndexOf("ab",4));
	}

}
