package exception;

import java.util.Scanner;

public class Test3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num = getNum();
		System.out.println(num);
	}
	
	public static int getNum(){
		Scanner input = new Scanner(System.in);//abc|100
		try{
			int num = input.nextInt();
			
		}catch(Exception e){
			
		}finally{
			return -1;
		}
	}

}
