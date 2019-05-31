package test;

/**
* @author 作者 Name:CaoGang
* @version 创建时间：2018年4月3日 上午10:06:52
* 类说明
*/
class SubThread2 extends Thread{
	private int b;
	SubThread2(int b) {
		this.b=b;
	}
	public void  run() {
		for(int i=0;i<b;i++) {
			System.out.println(Thread.currentThread().getName()+":"+i);
		}
	}
}
public class TestThread2 {
	public static void main(String[] args) throws InterruptedException {
		int a=1000;
		int b=200;
		SubThread2 subThread = new SubThread2(a);
		SubThread2 subThread1 = new SubThread2(b);
		subThread.setName("子线程①");
		subThread.start();
		subThread1.setName("子线程②");
		subThread1.start();
		System.out.println(subThread.isAlive());//判断当前线程是否还存活
		System.out.println(subThread1.isAlive());
		//subThread.yield();//主动放弃CPU资源
		Thread.sleep(2000);
		System.out.println(subThread.isAlive());
		System.out.println(subThread1.isAlive());
		//内部类的方式创建
		new Thread() {
			public void run() {
				Thread.currentThread().setName("OOOOOOOOOOOOOO:");
				System.out.println(Thread.currentThread().getName()+"============你好!");
			}
		}.start();
		new Thread() {
			public void run() {
				Thread.currentThread().setName("你好世界:");
				System.out.println(Thread.currentThread().getName()+"============你好!");
			}
		}.start();
	}
}
