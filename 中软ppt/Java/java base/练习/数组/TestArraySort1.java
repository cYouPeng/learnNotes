package javabase;

import java.util.Arrays;

public class TestArraySort1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[]{1,7,2,6,3,5,4};
		
		Arrays.sort(arr);
		for(int value : arr){
			System.out.println(value);
		}
		
		String[] arr2 = new String[]{"helloworld","abcdefg","你好"};
		Arrays.sort(arr2);
		for(String s : arr2){
			System.out.println(s);
		}
	}

}
