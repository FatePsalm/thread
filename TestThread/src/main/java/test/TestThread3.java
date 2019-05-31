package test;

/**
 * @author 作者 Name:CaoGang
 * @version 创建时间：2018年4月3日 上午10:06:52 类说明
 * 同步锁
 */
class TestRunnable implements Runnable {
	int ticket = 100;// 车票
	public void run() {
		while (true) {
			synchronized (this) {//this就是testRunnable这个类
				if (ticket > 0) {
					System.out.println(Thread.currentThread().getName() + ":" + "售票-座位号为" + ticket--);
				} else {
					System.err.println("已售罄");
					break;
				}
			}
		}
	}
}

public class TestThread3 {
	public static void main(String[] args) {
		TestRunnable testRunnable = new TestRunnable();
		Thread thread = new Thread(testRunnable);
		Thread thread2 = new Thread(testRunnable);
		Thread thread3 = new Thread(testRunnable);
		thread.start();
		thread2.start();
		thread3.start();
	}
}
