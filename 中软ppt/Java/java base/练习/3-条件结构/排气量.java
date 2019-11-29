package test8_8;

import java.util.Scanner;

public class Lianxi3_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//	         排气量在1.0升以下(含1.0升)的 1%
//	  　　排气量在1.0升以上至1.5升(含1.5升)的 3%
//	  　　排气量在1.5升以上至2.0升(含2.0升)的 5%
//	  　　排气量在2.0升以上至2.5升(含2.5升)的 9%
//	  　　排气量在2.5升以上至3.0升(含3.0升)的 12%
//	  　　排气量在3.0升以上至4.0升(含4.0升)的 25%
//	  　　排气量在4.0升以上的 40%
		Scanner input = new Scanner(System.in);
		double pai = input.nextDouble();
		int price = input.nextInt();
		double sax;
		if(pai<=1){
			sax = price * 0.01;
		}else if(pai<=1.5){
			sax = price * 0.03;
		}else if(pai<=2){
			sax = price * 0.05;
		}else if(pai<=2.5){
			sax = price * 0.09;
		}else if(pai<=3){
			sax = price * 0.12;
		}else if(pai<=4){
			sax = price * 0.25;
		}else{
			sax = price * 0.4;
		}
		System.out.println("需要缴纳税金"+sax+"元");
	}

}
