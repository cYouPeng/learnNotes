package thread;



public class TestDeamon {
	public static void main(String[]args){
		Thread t1 = new Thread(()->System.out.println("我是用户线程，看到我时我就结束了"));
		Thread t2 = new Thread(()->{
			while(true){
				System.out.println("我是守护线程，我会一直在的，除非……");
			}
		});
		t2.setDaemon(true);
		
		t2.start();
		t1.start();
		System.out.println("主线程结束");
	}
}
