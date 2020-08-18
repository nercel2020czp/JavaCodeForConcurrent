package 第03章_Java_线程.s09_interrupt方法详解.s04_打断park线程;

import java.util.concurrent.locks.LockSupport;

import utils.Utils;

public class c03_可以使用Thread_interrupted清除打断状态 {
	public static void main(String[] args) {
		test4();
	}
//	## isInterrupted() 判断是否被打断， 不会清除 打断标记
//	## interrupted() static 判断当前线程是否被打断 会清除 打断标记
	private static void test4() {
		Thread t1 = new Thread(() -> {
			for (int i = 0; i < 5; i++) {
				Utils.log("park...");
				LockSupport.park();
//				Thread.interrupted();
				Utils.log("打断状态： " + Thread.interrupted());
			}
		});
		t1.start();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		t1.interrupt();
	}
}
