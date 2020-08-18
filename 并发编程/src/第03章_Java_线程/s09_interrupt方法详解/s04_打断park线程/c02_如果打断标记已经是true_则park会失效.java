package 第03章_Java_线程.s09_interrupt方法详解.s04_打断park线程;

import java.util.concurrent.locks.LockSupport;

import utils.Utils;

public class c02_如果打断标记已经是true_则park会失效 {
	
	public static void main(String[] args) {
		test4();
	}
	
	private static void test4() {
		Thread t1 = new Thread(() -> {
			for (int i = 0; i < 5; i++) {
				Utils.log("park...");
				LockSupport.park();
				Utils.log("打断状态： " + Thread.currentThread().isInterrupted());
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
