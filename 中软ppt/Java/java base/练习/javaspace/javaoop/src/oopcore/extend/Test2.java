package oopcore.extend;

public class Test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

		
		Sup s = new Sub();
		s.method();
	}

}
class Sup{
	public void method(){
		System.out.println("父类方法");
	}
}
class Sub extends Sup{
	public void method(){
		System.out.println("子类方法");
	}
}
