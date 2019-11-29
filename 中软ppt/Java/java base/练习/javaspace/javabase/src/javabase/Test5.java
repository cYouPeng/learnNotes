package javabase;

import java.util.Scanner;

public class Test5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.println("请输入行数");
		int rowNum = input.nextInt();
		String[][] arr = new String[rowNum][];
		for(int i=0; i<arr.length; i++){
			System.out.println("请输入第"+(i+1)+"行的列数");
			int colNum = input.nextInt();
			arr[i] = new String[colNum];
			for(int j=0; j<arr[i].length; j++){
				System.out.println("请输入第"+(i+1)+"行,第"+(j+1)+"列的值");
				arr[i][j] = input.next();
			}
		}
		
		for(String[] row : arr){
			for(String data : row){
				System.out.print(data+"\t");
			}
			System.out.println();
		}
	}

}
