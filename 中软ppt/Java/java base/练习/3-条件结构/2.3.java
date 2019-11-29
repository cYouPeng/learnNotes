package test8_8;

import java.util.Scanner;

public class Lianxi3_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		<1500元		3	
//		<4500元		10	
//		<9000元		20	
//		<35000元		25	
//		<55000元		30	
//		<80000元		35	
//		>=80000元	45
		Scanner input = new Scanner(System.in);
		System.out.println("请输入扣除5险1金之后的工资");
		double money = input.nextDouble();
		double sax = 0;
		double chao = money-3500;
		double baseSax = 0;
		if(chao>0){
			sax = (chao<1500?chao:1500) * 0.03;
		}
		if(chao>1500){
			sax += (chao<4500?chao-1500:(4500-1500)) * 0.1;
		}
		//....
//		if(chao<=0){
//			sax = 0;
//		}else if(chao<=1500){
//			sax = chao * 0.03;
//		}else if(chao<=4500){
//			sax = chao * 0.1;
//		}else if(chao<=9000){
//			sax = chao * 0.2;
//		}else{
//			sax = chao * 0.25;
//		}
		System.out.println("应缴税金"+sax+"元");
		
	}

}
