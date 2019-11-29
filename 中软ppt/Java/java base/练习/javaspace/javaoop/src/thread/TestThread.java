package thread;

public class TestThread {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//mt就是一个县城对象
		MyThread mt1 = new MyThread("线程1",1000);//mt新建状态
		mt1.start();//mt转成就绪状态，等待cpu时间片达到运行状态，运行run方法的代码，run方法执行结束mt线程结束
		MyThread mt2 = new MyThread("线程2",2000);
		mt2.start();
//		MyThread my = new MyThread(1000);
//		Thread mt1 = new Thread(my, "线程1");
//		Thread mt2 = new Thread(new MyThread(200), "线程2");
//		mt1.start();
//		mt2.start();
		Thread mt3 = new Thread(()->{
			for(int i=10; i<=100; i+=10){
				System.out.println(i);
			}
		});
		
		
		mt3.start();
		
		mt1.jieshu();
	
		
		
	}

}

class MyThread extends Thread{
//class MyThread implements Runnable{
	private static int num=0;
	private int sleepTime;
	private boolean isStop = false;
	public MyThread(String name,int sleepTime) {
		super(name);
		this.sleepTime = sleepTime;
		// TODO Auto-generated constructor stub
	}
	
	public void jieshu(){
		System.out.println("end1");
		isStop = true;
		this.interrupt();
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=1; i<=10; i++){
			if(i==5){
				this.jieshu();
			}
			num++;
			System.out.println(Thread.currentThread().getName()+":i="+i+",num="+num);
			try {
				Thread.sleep(this.sleepTime);//线程进入阻塞，1s后进入就绪
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(isStop){
				System.out.println("end2");
				return;
			}
		}
	}
	
}
