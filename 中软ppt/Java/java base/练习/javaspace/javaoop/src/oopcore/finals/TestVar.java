package oopcore.finals;

public class TestVar {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		final int a = 10;
//		a++;//不能第二次赋值
		final int[] arr = {1,2,3};
		//引用类型的常量，不能改变引用关系，但是内部的属性或元素可以改变
		arr[1] = 10;
//		arr = new int[5];
		Student s1 = new Student();
		Student s2 = new Student(10,"lisi");
		System.out.println(s1);
		System.out.println(s2);
	}

}
class Student{
//	属性是final，在初始化块或构造器或在属性定义的位置为其赋初值,该属性不能拥有setter
	private static int num = 0;
	private final int id;
	private final int a = 10;
	private String name;
	public Student() {
		super();
		id = ++num;
	}
	public Student(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
}
