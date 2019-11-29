package oopcore;

public class TestOverride {
	public static void main(String[] agrs){
		StringBuffer sb = new StringBuffer("hello");
		String s = "hello";
		char[] arr ={'h','e','l','l','o'};
		Object o = new Object();
		
		System.out.println(s);
		System.out.println(arr);
		System.out.println(o.toString());
		System.out.println(sb.toString());
	}
}
