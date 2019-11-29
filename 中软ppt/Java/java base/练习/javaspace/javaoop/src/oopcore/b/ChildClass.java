package oopcore.b;

import oopcore.a.MyClass;

public class ChildClass extends MyClass {
	public void method(){

		super.publicFeild = 10;
		super.protectedFeild = 20;
		//MyClass中默认和私有的成员不能访问
	}
}
