package a;

public class Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int num = 1;
//		int sum = 0;
//		for(int i=0; i<5; i++){
//			int temp = num;
//			for(int j=0; j<i; j++){
//				temp = temp*10+num;
//			}
//			System.out.println(temp);
//			sum += temp;
//		}
//		System.out.println(sum);
		int num = 1;
		int sum = 0;
		int temp = num;
		for(int i=0; i<5; i++){
			sum += temp;
			temp = temp*10+num;
		}
		System.out.println(sum);
	}

}
