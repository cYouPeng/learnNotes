package oop1;

public class Test3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 10;
		int b = 20;
		Test3 t = new Test3();
		t.swap(a, b);
		System.out.println("a="+a+",b="+b);
		int[] arr = new int[]{1,2,3,4,5};
		t.swapArray(arr);
		for(int num : arr){
			System.out.println(num);
		}
	}
	
	public void swap(int a, int b){
		int temp = a;
		a = b;
		b = temp;
	}
	
	public void swapArray(int[] arr){
		
		for(int i=0, j=arr.length-1; i<j; i++,j--){
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
		}
	}

}
