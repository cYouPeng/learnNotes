package oopcore.interfaces;

public class UsbFan extends AbstractUsb implements Usb {

	@Override
	public void powerOn() {
		// TODO Auto-generated method stub
		System.out.println("风扇开始转动");
	}

	@Override
	public void powerOff() {
		// TODO Auto-generated method stub
		System.out.println("风扇停止转动");
	}


}
