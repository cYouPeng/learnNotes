package test8_8;

import java.util.Random;
import java.util.Scanner;

public class Lianxi3_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		Random ran = new Random();
		System.out.println("输入：1-石头 2-剪刀 3-布");
		int u1 = input.nextInt();
		int u2 = ran.nextInt(3)+1;
		switch(u2){
		case 1: System.out.println("计算机选石头"); break;
		case 2: System.out.println("计算机选剪刀"); break;
		case 3: System.out.println("计算机选布"); break;
		}
		if(u1==1 && u2==2 || u1==2 && u2==3 || u1==3 && u2==1){
			System.out.println("玩家1赢");
		}else if(u1==u2){
			System.out.println("平局");
		}else{
			System.out.println("玩家2赢");
		}
	}

}
