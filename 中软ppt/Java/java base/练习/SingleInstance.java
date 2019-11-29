package oopcore;

public class SingleInstance {
	public static void main(String[] args){
		MyClass c1 = MyClass.getInstance();
		MyClass c2 = MyClass.getInstance();
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c1==c2);
	}
}
/**
 * 这是一个单例的类
 * @author Administrator
 *
 */
class MyClass{
	//懒汉模式，需要返回单例的对象时，才创建这个唯一的对象
//	private static MyClass instance;
//	/**
//	 * 构造器定义为私有的，这样就可以阻止在其他类中创建本类的对象，即第一次调用getInstance方法时，才对instance属性进行实例化
//	 */
//	private MyClass(){
//		
//	}
//	public static MyClass getInstance(){
//		if(instance == null){
//			instance = new MyClass();
//		}
//		return instance;
//	}
	//恶汉模式
	private static MyClass instance;
	static{
		instance = new MyClass();
	}
	private MyClass(){
	
	}
	public static MyClass getInstance(){
		return instance;
	}
	
}
