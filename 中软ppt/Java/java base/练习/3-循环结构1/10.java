package test8_8;

import java.util.Scanner;

public class Lianxi4_10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int num1 = input.nextInt();
		int num2 = input.nextInt();
		for(int i=num1>num2?num1:num2; i<=num1*num2; i++){
			if(i%num1 == 0 && i%num2 == 0){
				System.out.println(i);
				break;
			}
		}
		
		
	}

}
