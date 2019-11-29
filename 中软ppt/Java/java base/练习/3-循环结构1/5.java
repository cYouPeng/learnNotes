package test8_8;

import java.util.Scanner;

public class Lianxi4_5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double sumPrice = 0;
		Scanner input = new Scanner(System.in);
		for(int i=1; i<=5; i++){
			System.out.println("请输入第"+i+"个商品的价格");
			sumPrice += input.nextDouble();
		}
		System.out.println("总价为"+sumPrice+"，均价为:"+sumPrice/5);
	}

}
