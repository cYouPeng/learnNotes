package javabase;

public class TestArraySort2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[]{1,7,2,6,3,5,4};
		
		for(int i=0; i<arr.length-1; i++){
			boolean isSorted = true;
			for(int j=0; j<arr.length-1-i; j++){
				if(arr[j]>arr[j+1]){
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
					isSorted = false;
				}
			}
			if(isSorted){
				break;
			}
		}

//		for(int lastSwap = arr.length-1;;){
//			int tempLastSwap=0;
//			for(int j=0; j<lastSwap; j++){
//				if(arr[j]>arr[j+1]){
//					int temp = arr[j];
//					arr[j] = arr[j+1];
//					arr[j+1] = temp;
//					tempLastSwap = j+1;
//				}
//			}
//			lastSwap = tempLastSwap;
//			if(lastSwap==0){
//				break;
//			}
//		}
		
		for(int num : arr){
			System.out.print(num+"\t");
		}

		
	}

}
