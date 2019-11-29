package string;

import java.io.UnsupportedEncodingException;

public class Test3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 100;
		String str = String.valueOf(a);
		System.out.println(str);
		char[] arr = {'h','e','l','l','o'};
		String s1 = String.valueOf(arr);
		String s2 = String.valueOf(arr, 3, 2);
		System.out.println(s1);
		System.out.println(s2);
		
		System.out.println("abab".compareTo("aba"));
		
		System.out.println("abc.png".endsWith("jpg"));
		
		try {
			byte[] chars = "hello".getBytes("utf-8");
			String s = new String(chars, "iso-8859-1");
			System.out.println("iso:"+s);
			chars = s.getBytes("iso-8859-1");
			System.out.println("utf8:"+new String(chars,"utf-8"));
			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println();
		
	}

}
