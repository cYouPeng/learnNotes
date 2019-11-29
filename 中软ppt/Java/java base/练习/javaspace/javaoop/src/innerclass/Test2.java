package innerclass;

import innerclass.Outer.Inner;
import innerclass.Outer.StaticInner;

public class Test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//在外部类之外创建其内部类的对象，
		Inner in = new Outer().new Inner();                         
		StaticInner si = new Outer.StaticInner();
		Plane keji = new Plane();
		Plane zhishengji = new Plane();
		class Gudingyi implements Fly{

			@Override
			public void flyUp() {
				// TODO Auto-generated method stub
				System.out.println("客机要滑跑起飞");
			}

			@Override
			public void flyDown() {
				// TODO Auto-generated method stub
				System.out.println("客机要滑跑降落");
			}
			
		}
		keji.move(new Gudingyi());
		Plane zhandouji = new Plane();
		zhandouji.move(new Gudingyi());
		
//		new 接口名(){重写接口的方法}，定义了一个接口的实现类，并创建这个类的对象
		zhishengji.move(new Fly(){

			@Override
			public void flyUp() {
				// TODO Auto-generated method stub
				System.out.println("垂直起飞");
			}

			@Override
			public void flyDown() {
				// TODO Auto-generated method stub
				System.out.println("垂直降落");
			}
			
		});
		
	}
	
}
interface Fly{
	void flyUp();
	void flyDown();
}
class Plane{
	public void move(Fly f){
		f.flyUp();
		f.flyDown();
	}
}

class Outer{
	private int instanceField;
	private static int staticField;
	private int i;
	public void test(int num){
		num  = 30;
		class LocalInner{
			public void method(){
				instanceField = 10;
				staticField = 20;
				//访问所在方法的局部变量，但是只能读，不能写
				System.out.println(num);
//				num = 30;
			}
		}
	}
	
	/**
	 * 成员内部类,可以访问外部类的所有（静态或实例）成员，不能去定义任何静态成员
	 * @author Administrator
	 *
	 */
	public class Inner{
		private int i;
		public void method(){
			instanceField = 10;
			staticField = 20;
			this.i = 10;//Inner的属性
			Outer.this.i = 20;//Outer的属性
		}
	}
	/**
	 * 静态内部类，只能访问外部类的静态成员，而无论访问是发生在内部类的静态域或非静态域中
	 * @author Administrator
	 *
	 */
	public static class StaticInner{
		public void method(){
//			instanceField = 10;
			staticField = 20;
		}
	}
	
}