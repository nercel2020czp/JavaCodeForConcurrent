package 第03章_Java_线程.s09_interrupt方法详解.s04_打断park线程;

import java.util.concurrent.locks.LockSupport;

import utils.Utils;

public class c01_打断park线程_不会清空打断状态 {
	
	public static void main(String[] args) {
		try {
			test3();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		2020年08月16日  - 08:19:07.346 - t1 - park...
//		2020年08月16日  - 08:19:07.843 - t1 - unpark...
//		2020年08月16日  - 08:19:07.843 - t1 - 打断状态： true
	}
	
	private static void test3() throws InterruptedException {
		Thread t1 = new Thread(() -> {
			Utils.log("park...");
			LockSupport.park();
			Utils.log("unpark...");
			Utils.log("打断状态： " + Thread.currentThread().isInterrupted());
		}, "t1");
		t1.start();
		Thread.sleep(5000);
		t1.interrupt();
	}
}
