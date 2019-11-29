package oopcore.a;

public class OtherClass {
	public void method(){
		MyClass c = new MyClass();
		c = new MyClass("lisi");
		c.publicFeild = 10;
		c.protectedFeild = 20;
		c.defaultFeild = 30;
//		c.privateFeild = 40;//不能访问
	}
}
