package 第04章_共享模型之管程.s12_活跃性.c03_活锁;

import utils.Utils;

public class Test01_TestLiveLock_活锁演示 {
	static volatile int count = 10;
	static final Object lock = new Object();

	public static void main(String[] args) {
		new Thread(() -> {
			// 期望减到 0 退出循环
			while (count > 0) {
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				count--;
				Utils.log("count:  " + count);
			}
		}, "t1").start();
		
		
		new Thread(() -> {
			// 期望超过 20 退出循环
			while (count < 20) {
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				count++;
				Utils.log("count:  " + count);
			}
		}, "t2").start();
	}
}
