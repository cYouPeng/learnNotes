package javabase;

public class Test3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arr1 = new int[][]{
			{1,2,3},
			{4,5,6}
		};
		int[][] arr2 = new int[arr1[0].length][arr1.length];
		for(int i=0; i<arr1.length; i++){
			for(int j=0; j<arr1[i].length; j++){
				arr2[j][i] = arr1[i][j];
			}
		}
		for(int[] row : arr2){
			for(int data : row){
				System.out.print(data+" ");
			}
			System.out.println();
		}
	}

}
