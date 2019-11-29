package oopcore.interfaces;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Usb usb = new UsbDisk();
		usb.powerOn();
		System.out.println(usb.read());
		usb.write("hello");
		usb.write(" world");
		System.out.println(usb.read());
		usb.powerOff();
		
		usb = new UsbFan();
		usb.powerOn();
		usb.powerOff();
		usb.write("hello");
		System.out.println(usb.read());
		
	}	

}
