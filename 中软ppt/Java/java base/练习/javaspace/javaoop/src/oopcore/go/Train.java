package oopcore.go;

public class Train extends Car {

	public Train() {
		// TODO Auto-generated constructor stub
	}

	public Train(double price) {
		super(price);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void go() {
		// TODO Auto-generated method stub
		System.out.println("花"+this.getPrice()+"元买票");
		System.out.println("等待并检票");
		System.out.println("上车");
		System.out.println("到达");
		System.out.println("下车");
	}

}
