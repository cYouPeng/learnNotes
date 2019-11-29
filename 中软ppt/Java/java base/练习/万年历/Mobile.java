package oop1;

public class Mobile {
	int price;
	String brand;
	String name;
	String os;
	
	public void showInfo(){
		System.out.println("我是"+brand+"牌子的手机，我具体的型号是："+name+"，使用"+os+"操作系统，卖"+price+"元");
	}
}
