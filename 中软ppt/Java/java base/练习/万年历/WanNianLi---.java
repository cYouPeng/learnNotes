import java.util.Scanner;

public class WanNianLi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.println("输入年和月");
		int year = input.nextInt();
		int month = input.nextInt();
		int sumDay = 0;
		for(int i=1900; i<year; i++){
			sumDay += i%4==0 && i%100!=0 || i%400==0 ? 366 : 365;
			//System.out.println(i+":"+(i%4==0 && i%100!=0 || i%400==0 ? 366 : 365));
		}
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
			case 2: dayNum = year%4==0 && year%100!=0 || year%400==0 ? 29 : 28; break;
			}
			System.out.println(i+":"+dayNum);
			sumDay +=dayNum;
		}
		int week = (sumDay+1)%7;
		int dayNum = 0;
		switch(month){
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
		case 2: dayNum = year%4==0 && year%100!=0 || year%400==0 ? 29 : 28; break;
		}
		System.out.println("日\t一\t二\t三\t四\t五\t六");
		int printNum = 0;
		for(int i=0; i<week; i++){
			System.out.print("\t");
			printNum++;
		}
		for(int i=1; i<=dayNum; i++){
			System.out.print(i+"\t");
			printNum++;
			if(printNum==7){
				printNum=0;
				System.out.println();
			}
		}
	}
}
