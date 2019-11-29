package oopcore;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Test().method(1);
		Object o = new Test();
		String s = o.toString();
		//编译期：静态绑定，Object类 toString方法，无参数
		//运行期：动态绑定，Test类，toString，无参
		Object o2 = new StringBuffer("hello");
		String s2 = o2.toString();
		//编译期：静态绑定，Object类 toString方法，无参数
		//运行期：动态绑定，StringBuffer类，toString，无参
	}
	
	public static void method(){
		
	}
	
	public static void method(int a){
		
	}

	@Override
	public String toString() {
		return "Test []";
	}

}
