package oop2;

public class TestUser {
	public static void main(String[] args){
		User u1 = new User();
		u1.name = "张三";
		u1.printInfo();
		User u2 = new User();
		u2.name = "李四";
		u2.printInfo();
		
		//静态域({}括起来的空间，包括不限于方法)没有this，这时被省略的可以认为是类名
		//sayHello();//TestUser.sayHello();//错误，因为对象方法只能用对象来调用，而不能用类名
		new TestUser().sayHello();
		staticMethod();//TestUser.staticMethod();
	}
	public void sayHello(){
		System.out.println("hello");
	}
	public static void staticMethod(){
		System.out.println("这时静态方法");
	}
}
class User{
	String name;
	int age;
	public void printInfo(){
		//this当前对象-调用这个方法的对象
		System.out.println(this.getInfo());
	}
	public String getInfo(){
		return "名字："+this.name+"年龄："+this.age;
	}
}
