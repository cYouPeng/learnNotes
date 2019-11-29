package oopcore.go;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner input = new Scanner(System.in);
		System.out.println("选择出行方式："+CarFactory.BUS_TYPE+"-公交 "+CarFactory.TAXI_TYPE+"-出租 "+CarFactory.TRAIN_TYPE+"-火车");
		int carType = input.nextInt();

		toFuShun(CarFactory.getCarInstance(3));
	}
	
	public static void toFuShun(Car car){
		//编译期：静态绑定，Car类 go方法，无参数
		//运行期：动态绑定，Bus/Taxi/Train类，go方法，无参
		car.go();
	}

}
