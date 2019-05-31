package senior;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author 作者 Name:CaoGang
 * @version 创建时间：2018年4月4日 上午10:08:04 类说明 原子可见性
 */
class Demo implements Runnable {
	//private int i=0;
	private AtomicInteger i=new AtomicInteger();
	public void run() {
		try {
			Thread.sleep(20);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+":"+getI());
	}
	public int getI() {
		return i.getAndIncrement();
	}
	
}

public class TestAtomic {
public static void main(String[] args) {
	Demo demo = new Demo();
	for (int i = 0; i < 10; i++) {
		new Thread(demo).start(); 
	}
}
}
