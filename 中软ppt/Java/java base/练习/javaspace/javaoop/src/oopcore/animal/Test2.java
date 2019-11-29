package oopcore.animal;

import java.util.Scanner;

public class Test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Test2 t = new Test2();
		Animal a = t.getAnimal();
		if(a!=null){
			t.action(a);
		}
	}
	public void action(Animal animal){
		System.out.println(animal);
		animal.eat();
	}
	public Animal getAnimal(){
		Animal a = null;
		Scanner input = new Scanner(System.in);
		System.out.println("请输入动物的类型");
		switch(input.next().toLowerCase()){
		case "dog": a = new Dog(); break;
		case "cat": a = new Cat(); break;
		default: return null;
		}
		//a的类型是Animal，所以只能调用Animal中定义或继承的方法
		System.out.println("分别输入姓名，颜色，年龄");
		a.setName(input.next());
		a.setColor(input.next());
		a.setAge(input.nextInt());
		return a;
	}
}
