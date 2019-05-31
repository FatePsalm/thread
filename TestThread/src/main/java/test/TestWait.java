package test;

/**
 * @author 作者 Name:CaoGang
 * @version 创建时间：2018年4月3日 下午4:32:43 类说明
 */
class TesetThread implements Runnable {
	private static int i=0;

	public void run() {
		while (true) {
			synchronized (this) {
				i++;
				System.out.println(i);
				notify();// 唤醒睡眠的线程
				String str = Thread.currentThread().getName();
				if (str.equals("我")) {
					System.out.println(str + "爱你!❤️");
				} else {
					System.out.println(str + "爱我!💖💗");
				}
				try {
					wait();// 睡眠执行的线程
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if (i==100) 
				return;
			}
		}
	}
}

public class TestWait {
	public static void main(String[] args) {
		TesetThread tesetThread = new TesetThread();
		Thread thread = new Thread(tesetThread);
		Thread thread2 = new Thread(tesetThread);
		thread.setName("我");
		thread2.setName("你");
		thread.start();
		thread2.start();
	}
}
