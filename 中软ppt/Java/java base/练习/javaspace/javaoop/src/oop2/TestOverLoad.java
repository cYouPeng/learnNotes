package oop2;

public class TestOverLoad {
	public static void main(String[] args){
		int result1 = method(1, 2);
		double result2 = method(1, 1.5);
		double result3 = method(1.0, 2.0);
	}
	
	public void method(String str){
		
	}
	public static void method(int num){
		
	}

	public static int method(int a, int b){
		return a*b;
	}
	public static double method(double a, double b){
		return a*b;
	}
}
