package oop1;

import java.util.Scanner;

public class Test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		String s1 = input.next();
		String s2 = input.next();
		
		//赋值的是s2所指向的内存地址，
		String s3 = s2;
		//==比较两个字符串是否是同一个对象，或者说s1和s2的值（字符串的内存地址）是否相同
		System.out.println(s1==s2);
		//equals比较两个字符串是否内容相同
		System.out.println(s1.equals(s2));
	}

}
