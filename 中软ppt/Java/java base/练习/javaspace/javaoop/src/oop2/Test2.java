package oop2;

class Test1 {

	


}

public class Test2{
	int num1;
	static int num2;
	public void method1(){
		num1 = 10;
		num2 = 20;
		method2();
	}
	public static void method2(){
		//num1 = 10;//静态方法只能直接访问本类静态成员
		num2 = 20;
		//method1();
		Test2 t = new Test2();
		t.num1 = 10;
		t.method1();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
	}
	
}
