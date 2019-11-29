package enums;

import java.util.Scanner;



public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.println("选择出行方式："+CarType.BUS.getIndex()+"-公交 "
						+CarType.TAXI.getIndex()+"-出租 "
						+CarType.TRAIN.getIndex()+"-火车");
		int index = input.nextInt();
		CarType type = CarType.getCarTypeByIndex(index);
		System.out.println(type);
		toFuShun(CarFactory.getCarInstance(type));
	}
	
	public static void toFuShun(Car car){
		//编译期：静态绑定，Car类 go方法，无参数
		//运行期：动态绑定，Bus/Taxi/Train类，go方法，无参
		car.go();
	}

}
