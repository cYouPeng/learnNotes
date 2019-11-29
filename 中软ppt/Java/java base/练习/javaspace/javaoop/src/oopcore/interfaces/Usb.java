package oopcore.interfaces;

public interface Usb {
	void powerOn();
	void powerOff();
	default String read(){
		System.out.println("默认实现的read()");
		return null;
	}
	default void write(String info){
//		System.out.println("默认实现的write()");
	}
}
