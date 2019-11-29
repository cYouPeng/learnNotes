package oop2;

public class TestVar {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[10];
		for(int i=0; i<arr.length; i++){
			int value = arr[i];
		}
		
		final int a = 10;
		String s1 = "hello";
		String s2 = "hello";
		System.out.println(s1==s2);
		String s3 = new String("hello");
		String s4 = new String("hello");
		System.out.println(s3==s4);
		
		
		TestVar tv = new TestVar();
		tv.a();
		//a方法调用结束其内部的局部变量s会跟着a方法对应的栈区一起被回收
		//但是此时s所指向的字符串对象，仍然在堆区中存在，只不过没有引用指向他，就不能在使用了
	}
	public void a(){
		int age;
		String s = new String();
		this.b();
		this.c();
	}
	public void b(){
		boolean type;
	}
	public void c(){
		double money;
	}

}
