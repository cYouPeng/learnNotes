package collection;

public class Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[10];
		for(int i=0; i<arr.length-1; i++){
			arr[i] = (i+1)*10;
		}
		for(int value : arr){
			System.out.print(value+" ");
		}
		int index = 5;
		for(int i=arr.length-1;i>index; i--){
			arr[i] = arr[i-1];
		}
		arr[index] = 99;
		System.out.println();
		for(int value : arr){
			System.out.print(value+" ");
		}
	}

}
