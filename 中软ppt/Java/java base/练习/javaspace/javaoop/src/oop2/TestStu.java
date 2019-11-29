package oop2;

public class TestStu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stu.method();
		Stu stu1 = new Stu();
		stu1.printInfo();
		Stu stu2 = new Stu("lisi");
		stu2.printInfo();
	}

}
class Stu{
	static int num;
	int id;
	String name;
	static{
		//在类被加载的时候执行
		num = 0;
		System.out.println("静态初始化块 num=0");
	}
	{
		//创建对象的时候在构造器中的代码执行之前
		this.id = ++num;
		System.out.println("实例初始化块1");
	}
	
	public Stu(){
		//this.id = ++num;
		System.out.println("无参数构造器");
	}
	public Stu(String name){
		//this();
		this.name = name;
		System.out.println("带参数构造器");
	}
	public void printInfo(){
		System.out.println("id="+id+" ,name="+name);
	}
	public static void method(){
		System.out.println("静态方法");
	}
}