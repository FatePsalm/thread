package test;

/**
* @author 作者 Name:CaoGang
* @version 创建时间：2018年4月3日 上午10:06:52
* 类说明
*/
class SubThread extends Thread{
	public void  run() {
		for(int i=0;i<10;i++) {
			System.out.println(Thread.currentThread().getName()+":"+i);
		}
	}
}
public class TestThread {
	public static void main(String[] args) {
		SubThread subThread = new SubThread();
		SubThread subThread1 = new SubThread();
		subThread.start();
		subThread1.start();
	}
}
