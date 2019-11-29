package test8_8;

import java.util.Random;
import java.util.Scanner;

public class Lianxi4_16 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		Random ran = new Random();
		int userWinNum = 0;
		int computerWinNum = 0;
		while(true){
			System.out.println("输入：1-石头 2-剪刀 3-布");
			int user = input.nextInt();
			int computer = ran.nextInt(3)+1;
			switch(computer){
			case 1: System.out.println("计算机选石头"); break;
			case 2: System.out.println("计算机选剪刀"); break;
			case 3: System.out.println("计算机选布"); break;
			}
			if(user==1 && computer==2 || user==2 && computer==3 || user==3 && computer==1){
				System.out.println("玩家赢");
				userWinNum++;
			}else if(user==computer){
				System.out.println("平局");
			}else{
				System.out.println("电脑应赢");
				computerWinNum++;
			}
			if(userWinNum==4 || computerWinNum==4){
				break;
			}
		}
		if(userWinNum==4){
			System.out.println("玩家最终胜利");
		}else{
			System.out.println("电脑最终胜利");
		}
	}

}
