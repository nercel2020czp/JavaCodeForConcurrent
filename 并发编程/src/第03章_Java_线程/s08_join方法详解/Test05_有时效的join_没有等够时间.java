package 第03章_Java_线程.s08_join方法详解;

import java.util.concurrent.TimeUnit;

import utils.Utils;

public class Test05_有时效的join_没有等够时间 {
	static int r1 = 0;
	static int r2 = 0;

	public static void main(String[] args) throws InterruptedException {
		test3();
	}

	public static void test3() throws InterruptedException {
		Thread t1 = new Thread(() -> {
			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			r1 = 10;
		});
		long start = System.currentTimeMillis();
		t1.start();
		// 线程执行结束会导致 join 结束
		////Waits at most millis milliseconds for this thread to die
		t1.join(1500);
		long end = System.currentTimeMillis();
		Utils.log("r1: " + r1 + " r2: " + r2 + " cost: " + (end - start));
	}
}
