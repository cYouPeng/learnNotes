package oopcore.a;

public class MyClass {
	public int publicFeild;
	protected int protectedFeild;
	int defaultFeild;
	private int privateFeild;
	
	private  MyClass(){
		
	}
	public MyClass(String name){
		
	}
	
	public void method(){
		this.publicFeild = 10;
		this.protectedFeild = 20;
		this.defaultFeild = 30;
		this.privateFeild = 40;
	}
}
