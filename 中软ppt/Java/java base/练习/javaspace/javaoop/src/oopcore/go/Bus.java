package oopcore.go;

public class Bus extends Car {

	public Bus() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Bus(double price) {
		super(price);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void go() {
		// TODO Auto-generated method stub
		System.out.println("上车");
		System.out.println("投币"+this.getPrice()+"元");
		System.out.println("到达");
		System.out.println("下车");
	}

}
