package oopcore.go;

public class Taxi extends Car {

	public Taxi() {
		// TODO Auto-generated constructor stub
	}

	public Taxi(double price) {
		super(price);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void go() {
		// TODO Auto-generated method stub
		System.out.println("拦车");
		System.out.println("上车");
		System.out.println("告知目的地");
		System.out.println("到达");
		System.out.println("支付车费"+this.getPrice()+"元");
		System.out.println("下车");
	}

}
