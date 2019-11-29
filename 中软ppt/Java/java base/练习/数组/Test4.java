package javabase;
/**
 * 水平垂直反转数组
 * @author Administrator
 *
 */
public class Test4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	
		int[][] arr = new int[][]{
			{1,2,3,4},
			{5,6,7,8},
			{9,10,11,12},
		};
		for(int[] row : arr){
			for(int i=0; i<row.length/2; i++){
				int temp = row[i];
				row[i] = row[row.length-1-i];
				row[row.length-1-i] = temp;
			}
		}
		for(int i=0; i<arr.length/2; i++){
			int[] temp = arr[i];
			arr[i] = arr[arr.length-1-i];
			arr[arr.length-1-i] = temp;
		}
		
		for(int[] row : arr){
			for(int data : row){
				System.out.print(data+"\t");
			}
			System.out.println();
		}
	}
}
