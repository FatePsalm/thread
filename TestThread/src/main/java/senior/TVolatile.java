package senior;

/**
 * @author 作者 Name:CaoGang
 * @version 创建时间：2018年4月3日 下午5:32:08 类说明 volatile 修饰变量的内存可见性
 */
/*
 * 一、volatile 关键字：当多个线程进行操作共享数据时，可以保证内存中的数据可见。
 * 					  相较于 synchronized 是一种较为轻量级的同步策略。
 *
 * 注意：
 * 1. volatile 不具备“互斥性”
 * 2. volatile 不能保证变量的“原子性”
 */
public class TVolatile {
	public static void main(String[] args) throws InterruptedException {
		ThreadDemo threadDemo = new ThreadDemo();
		new Thread(threadDemo).start();
		while (true) {
			boolean flag = threadDemo.isFlag();
			if (flag) {
				System.out.println("******************");
				break;
			}
		}
	}
}

class ThreadDemo implements Runnable {
	private volatile boolean flag = false;

	public void run() {
		try {
			Thread.sleep(20);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		flag = true;
		System.out.println("flag值:" + isFlag());
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

}
