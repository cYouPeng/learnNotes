package oopcore.animal;

public class Cat extends Animal{

	public void catchMouse(){
		System.out.println(this.getName()+"在抓老鼠");
	}
	public void eat(){
		System.out.println(this.getName()+"在吃鱼");
	}
	
	public void testEat(){
		this.eat();//Cat类重写的eat()
		super.eat();//Cat继承Animal的eat();
	}
}
