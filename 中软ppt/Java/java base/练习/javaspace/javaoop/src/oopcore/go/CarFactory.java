package oopcore.go;

public abstract class CarFactory {
	public static final int BUS_TYPE = 1<<0;
	public static final int TAXI_TYPE = 1<<1;
	public static final int TRAIN_TYPE = 1<<2;
	public static Car getCarInstance(int carType){
		switch(carType){
		case BUS_TYPE: return new Bus(11);
		case TAXI_TYPE: return new Taxi(50);
		case TRAIN_TYPE: return new Train(6);
		}
		return null;
	}
}
