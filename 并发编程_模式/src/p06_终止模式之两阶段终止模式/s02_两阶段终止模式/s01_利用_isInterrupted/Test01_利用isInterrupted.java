package p06_终止模式之两阶段终止模式.s02_两阶段终止模式.s01_利用_isInterrupted;
//interrupt 可以打断正在执行的线程，无论这个线程是在 sleep，wait，还是正常运行

import utils.Utils;

class TPTInterrupt {
	private Thread thread;
	public void start() {
		thread = new Thread(() -> {
			while (true) {
				Thread current = Thread.currentThread();
				System.out.println(current == thread);//true
				if (current.isInterrupted()) {
					Utils.log("料理后事");
					break;
				}
				try {
					Thread.sleep(1000);
					Utils.log("将结果保存");
				} catch (InterruptedException e) {
					e.printStackTrace();
					//重新设置打断标记
					//https://blog.csdn.net/Justin_bibo/article/details/107730316
					current.interrupt();
				}
				// 执行监控操作
			}
		}, "监控线程");
		thread.start();
	}

	public void stop() {
		thread.interrupt();
	}
}


public class Test01_利用isInterrupted {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		TPTInterrupt t = new TPTInterrupt();
		t.start();
		Thread.sleep(3500);
		Utils.log("主线程开始打断子线程");
		t.stop();
//		Thread.sleep(10000);
//		Utils.log("主线程打断子线程完毕");
	}

}
