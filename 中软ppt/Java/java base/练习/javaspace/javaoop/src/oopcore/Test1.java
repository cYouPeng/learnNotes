package oopcore;

import java.util.Scanner;

public class Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 1<<0;//001
		int b = 1<<1;//010
		int c = 1<<2;//100
		Scanner input = new Scanner(System.in);
		int value = 0;
		boolean isEnd = true;
		while(isEnd){
			String s = input.next();
			switch(s){
			case "a":value = value|a;break;
			case "b":value = value|b;break;
			case "c":value = value|c;break;
			case "end":isEnd = false;
			}
		}

		System.out.println(value);
		
		if((value&a)==a){
			System.out.println("a");
		}
		if((value&b)==b){
			System.out.println("b");
		}
		if((value&c)==c){
			System.out.println("c");
		}
				
	}

}
