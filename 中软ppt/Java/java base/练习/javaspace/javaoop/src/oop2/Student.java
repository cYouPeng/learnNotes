package oop2;

public class Student {
	int id;
	String name;
//	public Student(){

//	}
	public Student(int id){

		this.id = id;
	}
	public Student(int id, String name){
		
		//this.id = id;//this表示正在创建的对象
		this(id);//调用构造器public Student(int id)
		//this.name = name;
		this.setName(name);
	}
	public void setName(String name){
		this.name = name;
	}
}
