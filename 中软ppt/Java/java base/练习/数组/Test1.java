package javabase;

import java.util.Scanner;

public class Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.println("请输入商品的数量");
		int num = input.nextInt();
		int[] priceArr = new int[num];
		for(int i=0; i<priceArr.length; i++){
			System.out.println("请输入第"+(i+1)+"个商品价格");
			priceArr[i] = input.nextInt();
		}
		int sumPrice = 0;
		for(int price : priceArr){
			sumPrice += price;
		}
//		for(int i=0; i<priceArr.length; i++){
//			int price = priceArr[i];
//			sumPrice += price;
//		}
		int minPrice = priceArr[0];
		for(int p : priceArr){
			if(minPrice>p){
				minPrice = p;
			}
		}
//		for(int i=0; i<priceArr.length; i++){
//			if(minPrice>priceArr[i]){
//				minPrice = priceArr[i];
//			}
//		}
		int maxPrice = priceArr[0];
		for(int i=0; i<priceArr.length; i++){
			if(maxPrice < priceArr[i]){
				maxPrice = priceArr[i];
			}
		}
	}

}
