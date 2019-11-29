package test8_8;

import java.util.Scanner;

public class Lianxi4_13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		double sumPrice = 0;
		int count = 0;
		while(true){
			
			System.out.println("是否继续输入商品的价格(true|false)");
			boolean isInput = input.nextBoolean();
			if(!isInput){
				break;
			}
			System.out.println("请输入商品的价格：");
			sumPrice += input.nextDouble();
			count++;
		}
		System.out.println("总价为："+sumPrice+"，均价为："+sumPrice/count);
	}

}
