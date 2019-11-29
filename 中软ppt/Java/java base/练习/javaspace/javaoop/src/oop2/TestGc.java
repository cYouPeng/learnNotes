package oop2;

public class TestGc {
	public static void main(String[] args){
		
		for(int i=1;i<1000;i++){
			A a = new A(String.valueOf(i));
			if(i==100){
				System.gc();
			}
		}
	}
}
class A{
	String name;
	public A(String name){
		this.name = name;
		System.out.println("对象:"+name+"被创建");
	}
	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
		System.out.println("\t\t对象:"+name+"被回收");
	}
	
}
