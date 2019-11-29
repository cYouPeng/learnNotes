package wrapper;

import java.util.Random;

public class Test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer sum = 0;
//		for(int i=0; i<10; i++){
//			sum = sum + new Random().nextInt(50);//sum会每次指向新的wraper类对象
//		}
		int tempSum = sum;
		Random ran = new Random();
		for(int i=0; i<10; i++){
			tempSum = tempSum + ran.nextInt(50);
		}
		sum = tempSum;
		System.out.println(sum);
	}

}
