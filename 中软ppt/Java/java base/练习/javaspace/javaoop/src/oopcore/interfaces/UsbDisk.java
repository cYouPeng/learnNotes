package oopcore.interfaces;

public class UsbDisk extends Object implements Usb {
	private StringBuffer info;
	private boolean isPower;
	{
		info = new StringBuffer();
	}
	@Override
	public void powerOn() {
		// TODO Auto-generated method stub
		System.out.println("u盘以连通");
		this.isPower = true;
	}

	@Override
	public void powerOff() {
		// TODO Auto-generated method stub
		System.out.println("u盘成功弹出");
		this.isPower = false;
	}

	@Override
	public String read() {
		// TODO Auto-generated method stub
		
		return this.isPower?info.toString():"无法读取";
	}

	@Override
	public void write(String info) {
		// TODO Auto-generated method stub
		if(isPower){
			this.info.append(info);
		}
	}

	
	
}
