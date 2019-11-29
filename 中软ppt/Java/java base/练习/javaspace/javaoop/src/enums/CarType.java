package enums;

public enum CarType {
	BUS(1,11), TAXI(2,40), TRAIN(3,15);
	private int index;
	private double price;

	private CarType(int index, double price){
		this.index = index;
		this.price = price;
	}
	public static CarType getCarTypeByIndex(int index){
		for(CarType type : CarType.values()){
			if(type.index == index){
				return type;
			}
		}
		return null;
	}
	
	public double getPrice(){
		return this.price;
	}
	public int getIndex() {
		return index;
	}

}
