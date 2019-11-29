package javabase;

public class Test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arr1 = new int[2][3];
		arr1[0][0] = 1;
		arr1[0][1] = 2;
		arr1[0][2] = 3;
		arr1[1][0] = 4;
		arr1[1][1] = 5;
		arr1[1][2] = 6;
		//123
		//456
		int[][] arr2 = new int[][]{
			{1,1,0,1,2,2,2,2,1,0,1,1},
			{1,1,0,1,1,2,2,1,1,0,1,1},
			{1,1,0,1,1,2,2,1,1,0}
		};
		
		int[][] arr3 = new int[3][];
		arr3[0] = new int[]{1,2};
		arr3[1] = new int[]{3,4,5,6};
		arr3[2] = new int[3];
		arr3[2][0] = 7;
		arr3[2][1] = 8;
		arr3[2][2] = 9;
		for(int i=0; i<arr3.length; i++){
			for(int j=0; j<arr3[i].length; j++){
				System.out.print(arr3[i][j]+" ");
			}
			System.out.println();
		}
		for(int i=0; i<arr3.length; i++){
			int[] row = arr3[i];
			for(int j=0; j<row.length; j++){
				System.out.print(row[j]+" ");
			}
			System.out.println();
		}
		for(int[] row : arr3){
			for(int cell : row){
				System.out.print(cell+" ");
			}
			System.out.println();
		}
		
		
		
		//12
		//3456
		//789
	}

}
