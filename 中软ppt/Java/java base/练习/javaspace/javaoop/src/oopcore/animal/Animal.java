package oopcore.animal;

public abstract class Animal {
	private int age;
	private String name;
	private String color;
	
	public Animal(){
		super();
		System.out.println("Animal()");
	}
	public Animal(int age, String name, String color){
		super();
		System.out.println("Animal(3param)");
		this.age = age;
		this.name = name;
		this.color = color;
	}
	
	public void eat(){
		System.out.println(name+"在吃东西");
	}
	
	
	public void setAge(int age){
		this.age = age;
	}
	public int getAge(){
		return age;
	}
	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return name;
	}
	public void setColor(String color){
		this.color = color;
	}
	public String getColor(){
		return color;
	}
}
