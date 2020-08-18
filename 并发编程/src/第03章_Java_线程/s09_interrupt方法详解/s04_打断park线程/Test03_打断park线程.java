package 第03章_Java_线程.s09_interrupt方法详解.s04_打断park线程;
//打断 park 线程, 不会清空打断状态
//如果打断标记已经是 true, 则 park 会失效
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

import utils.Utils;

public class Test03_打断park线程 {
	public static void main(String[] args) {
		test3();
//		test4();
	}
	
	//打断 park 线程, 不会清空打断状态
	private static void test3() {
		Thread t1 = new Thread(() -> {
			Utils.log("park...");
			LockSupport.park();
			Utils.log("unpark...");
			Utils.log("打断状态：" + Thread.interrupted());
			//打断 park 线程, 不会清空打断状态
			//如果打断标记已经是 true, 则 park 会失效
			//以下代码就不会执行了
			LockSupport.park();
			Utils.log("unpark...");
		}, "t1");
		t1.start();
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		t1.interrupt();
	}
	//如果打断标记已经是 true, 则 park 会失效
	private static void test4() {
		Thread t1 = new Thread(() -> {
			for (int i = 0; i < 5; i++) {
				Utils.log("park...");
				LockSupport.park();
				Utils.log("打断状态：" + Thread.currentThread().isInterrupted());
			}
		});
		t1.start();
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		t1.interrupt();
	}
}
