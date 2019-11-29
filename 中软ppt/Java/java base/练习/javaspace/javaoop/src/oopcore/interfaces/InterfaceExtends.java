package oopcore.interfaces;

public class InterfaceExtends {
	public static void main(String[] args){
		Imp i = new Imp();
		i.m();
	}
}

interface A{
	default void method1(){
		System.out.println("this is method1()");
	}
	void method3();
	//因为接口A、B中都存在method3，所以这个方法在A、B中都不能提供默认的方法体，
	//否则因为存在菱形派生问题而在多重继承时报编译错误
}
interface B{
	default void method2(){
		System.out.println("this is method2()");
	}
	void method3();
}

interface C extends A, B{
	
}

class CImp implements C{
	public void method3(){
		
	}
}

interface I{
	void m();
}
interface I1 extends I{
	default void m(){
		System.out.println("I1 default m()");
	}
}
interface I2 extends I{
	default void m(){
		System.out.println("I2 default m()");
	}
}

class Imp implements I1, I2{
	
}

