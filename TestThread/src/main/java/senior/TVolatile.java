package senior;

/**
 * @author 作者 Name:CaoGang
 * @version 创建时间：2018年4月3日 下午5:32:08 类说明 volatile 修饰变量的内存可见性
 */
public class TVolatile {
	public static void main(String[] args) throws InterruptedException {
		ThreadDemo threadDemo = new ThreadDemo();
		new Thread(threadDemo).start();
		while (true) {
			if (threadDemo.isFlag()) {
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
