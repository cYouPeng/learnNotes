package oopcore.animal;

public class Dog extends Animal{
	private int id;
	public Dog(){
		super();
		System.out.println("Dog()");
	}
	public Dog(int age, String name, String color, int id){
		super(age, name, color);
		
		this.id = id;
		
	}
	@Override
	public String toString(){
		return super.toString()+"\n"+"我是一条可爱的"+this.getColor()+"狗狗，我的名字叫"+this.getName()+"，我今年"+this.getAge()+"岁了，我主人给我编号为："+id;
	}
	public void lookHome(){
		System.out.println(this.getName()+"在看家");
	}
	public void eat(){
		System.out.println(this.getName()+"在吃骨头");
	}
	public void setId(int id){
		this.id = id;
	}
	public int getId(){
		return id;
	}
}
