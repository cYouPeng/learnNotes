package test8_8;

import java.util.Scanner;

public class Lianxi4_11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int num1 = input.nextInt();
		int num2 = input.nextInt();
		for(int i=num1<num2?num1:num2; i>=1; i--){
			if(num1%i==0 && num2%i==0){
				System.out.println(i);
				break;
			}
		}
	}

}
