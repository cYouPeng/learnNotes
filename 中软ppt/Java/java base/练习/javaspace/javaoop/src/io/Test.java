package io;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//方法的递归调用，在一个方法中对自身进行调用
		Test t = new Test();
	
//		int result = t.calcJiecheng(10);
//		System.out.println(result);
		
		int index = t.getIndex();
		System.out.println(index);
	}
	public int getIndex(){
		Scanner input = new Scanner(System.in);
		System.out.println("请问你排第几位？（不知道输入-1）");
		int index = input.nextInt();
		if(index<0){
			return this.getIndex()+1;
		}
		return index;
	}
	public int calcJiecheng(int num){
		if(num==1){
			return 1;
		}
		return num*this.calcJiecheng(num-1);
	}
}
