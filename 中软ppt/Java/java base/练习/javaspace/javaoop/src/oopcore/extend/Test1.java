package oopcore.extend;

public class Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Super s = new Super();
		s.printNum();
		Child c = new Child();
		c.printNum();
	}

}
class Super{
	public int num;
	{
		num = 10;
		System.out.println("super init block,num:"+num);
	}
	public Super(){
		num++;
		System.out.println("super constructor,num:"+num);
	}
	public void printNum(){
		System.out.println("super num="+num);
	}
}
class Child extends Super{
	public int num;
	{
		num = 20;
		System.out.println("child init block,num:"+num);
	}
	public Child(){
		num++;
		System.out.println("child constructor,num:"+num);
	}
//	public void printNum(){
//		System.out.println("Child num="+num);
//	}
}
