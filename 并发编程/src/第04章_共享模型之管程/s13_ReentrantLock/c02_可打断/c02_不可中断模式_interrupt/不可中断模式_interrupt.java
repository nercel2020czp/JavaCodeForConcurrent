package 第04章_共享模型之管程.s13_ReentrantLock.c02_可打断.c02_不可中断模式_interrupt;

import java.util.concurrent.locks.ReentrantLock;

import utils.Utils;

public class 不可中断模式_interrupt {

	public static void main(String[] args) throws InterruptedException {
		ReentrantLock lock = new ReentrantLock();
		Thread t1 = new Thread(() -> {
			Utils.log("启动...");
			lock.lock();
			try {
				Utils.log("获得了锁");
			} finally {
				lock.unlock();
			}
		}, "t1");
		
		
		lock.lock();
		Utils.log("获得了锁");
		t1.start();
		try {
			Thread.sleep(5000);
			t1.interrupt();
			Utils.log("执行打断");
			Thread.sleep(5000);
		} finally {
			Utils.log("释放了锁");
			lock.unlock();
		}
	}

}
