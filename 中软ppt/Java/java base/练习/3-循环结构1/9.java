package test8_8;

import java.util.Scanner;

public class Lianxi5_9 {
	public static void main(String[] args){
		int sumDay = 0;
		for(int i=1900; i<2010; i++){
			sumDay += i%4==0 && i%100!=0 || i%400==0 ? 366 : 365;
//			if(i%4==0 && i%100!=0 || i%400==0){
//				sumDay += 366;
//			}else{
//				sumDay += 365;
//			}
		}
		System.out.println(sumDay);
		
	}
}
