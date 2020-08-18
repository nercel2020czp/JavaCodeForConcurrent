package 第04章_共享模型之管程.s13_ReentrantLock.c03_锁超时.c01_立刻失败;

import java.util.concurrent.locks.ReentrantLock;

import utils.Utils;

public class 立刻失败 {

	public static void main(String[] args) {
		ReentrantLock lock = new ReentrantLock();
		Thread t1 = new Thread(() -> {
			Utils.log("启动...");
			if (!lock.tryLock()) {
				Utils.log("获取立刻失败，返回");
				return;
			}
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
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} finally {
			lock.unlock();
		}
	}

}
