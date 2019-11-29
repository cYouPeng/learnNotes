package test8_8;

import java.util.Scanner;

public class Lianxi4_8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int month = input.nextInt();
		int sumDay = 0;
		for(int i=1; i<month; i++){
			int dayNum = 0;
			switch(i){
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12: dayNum = 31; break;
			case 4:
			case 6:
			case 9:
			case 11: dayNum = 30; break;
			case 2: dayNum = 28; break;
			}
			sumDay +=dayNum;
		}
		System.out.println(sumDay);
		
	}

}
