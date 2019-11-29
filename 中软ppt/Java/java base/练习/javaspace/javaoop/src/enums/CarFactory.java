package enums;

public abstract class CarFactory {

	public static Car getCarInstance(CarType type){
		Car car = null;
		switch(type){
		case BUS: car = new Bus(); break;
		case TAXI: car = new Taxi(); break;
		case TRAIN: car = new Train(); break;
		default: return null;
		}
		car.setPrice(type.getPrice());
		return car;
	}
}
