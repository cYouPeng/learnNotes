package test8_8;

import java.util.Scanner;

public class Lianxi4_6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		boolean isZhiShu = true;
		int num = input.nextInt();
		for(int i=2; i<=num; i++){
			if(num%i==0){
				isZhiShu = false;
				break;
			}
		}
		if(isZhiShu){
			System.out.println(num+"是质数");
		}else{
			System.out.println(num+"是合数");
		}
	}

}
