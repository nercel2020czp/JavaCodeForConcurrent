package 第06章_共享模型之无锁.s02_CAS与volatile.c01_慢动作分析;

import java.util.concurrent.atomic.AtomicInteger;

import utils.Utils;

public class SlowMotion {
	public static void main(String[] args) {
		AtomicInteger balance = new AtomicInteger(10000);
		int mainPrev = balance.get();
		Utils.log("try get :" + mainPrev);
		new Thread(() -> {
			sleep(1000);
			int prev = balance.get();
			boolean isSuccess = balance.compareAndSet(prev, 9000);
			Utils.log("is success ? : " + isSuccess);
			Utils.log(balance.toString());
		}, "t1").start();
		sleep(2000);
		Utils.log("try set 8000...");
		boolean isSuccess = balance.compareAndSet(mainPrev, 8000);
		Utils.log("is success ? : " + isSuccess);
		if (!isSuccess) {
			mainPrev = balance.get();
			Utils.log("try set 8000...");
			isSuccess = balance.compareAndSet(mainPrev, 8000);
			Utils.log("is success ?  : " + isSuccess);
		}
	}

	private static void sleep(int millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
