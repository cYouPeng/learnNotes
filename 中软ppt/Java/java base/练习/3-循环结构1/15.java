package test8_8;

import java.util.Random;
import java.util.Scanner;

public class Lianxi4_15 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random ran = new Random();
		Scanner input = new Scanner(System.in);
		int ranNum = ran.nextInt(100)+1;
		while(true){
			System.out.println("输入你所猜的数字");
			int num = input.nextInt();
			if(num == ranNum){
				System.out.println("猜对了");
				break;
			}else if(num > ranNum){
				System.out.println("猜的太大了，下次小点");
			}else{
				System.out.println("猜的有点小，下次大点");
			}
		}
	}

}
