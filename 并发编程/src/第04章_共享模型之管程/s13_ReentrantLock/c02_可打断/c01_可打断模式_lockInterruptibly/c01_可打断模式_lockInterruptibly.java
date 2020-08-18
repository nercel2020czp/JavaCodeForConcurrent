package 第04章_共享模型之管程.s13_ReentrantLock.c02_可打断.c01_可打断模式_lockInterruptibly;

import java.util.concurrent.locks.ReentrantLock;

import utils.Utils;

public class c01_可打断模式_lockInterruptibly {

	public static void main(String[] args) {
		ReentrantLock lock = new ReentrantLock();
		Thread t1 = new Thread(() -> {

			Utils.log("启动...");
			try {
				lock.lockInterruptibly();
			} catch (InterruptedException e) {
				e.printStackTrace();
				Utils.log("等锁的过程中被打断");
				return;
			}
			try {
				Utils.log("获得了锁");
			} finally {
				lock.unlock();
			}
		}, "t1");
		
		///////////////////////////////
		lock.lock();
		Utils.log("获得了锁");
		t1.start();
		try {
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			t1.interrupt();
			Utils.log("执行打断");
		} finally {
			lock.unlock();
		}
	}

}
