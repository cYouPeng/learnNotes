package oopcore.animal;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		new Dog(5,"欧迪","棕色",110);
		Animal a = null;
		Scanner input = new Scanner(System.in);
		switch(input.next().toLowerCase()){
		case "dog": a = new Dog(); break;
		case "cat": a = new Cat(); break;
		}
		//a的类型是Animal，所以只能调用Animal中定义或继承的方法
		a.setName(input.next());
		a.eat();
	
		
//		Dog d = new Dog(5,"欧迪","棕色",110);
//		System.out.println(d);
//		d.eat();
//		d.lookHome();
//		
//		Cat cat = new Cat();
//		System.out.println(cat);
//		cat.setName("加菲");
//		cat.catchMouse();
//		cat.eat();
	}

}
