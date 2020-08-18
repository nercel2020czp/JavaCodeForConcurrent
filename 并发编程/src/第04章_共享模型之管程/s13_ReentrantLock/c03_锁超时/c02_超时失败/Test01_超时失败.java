package 第04章_共享模型之管程.s13_ReentrantLock.c03_锁超时.c02_超时失败;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

import utils.Utils;

public class Test01_超时失败 {

	public static void main(String[] args) throws InterruptedException {
		ReentrantLock lock = new ReentrantLock();
		Thread t1 = new Thread(() -> {
			Utils.log("启动...");
			try {
				if (!lock.tryLock(1, TimeUnit.SECONDS)) {
					Utils.log("获取等待 1s 后失败，返回");
					return;
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
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
			Thread.sleep(2000);
		} finally {
			lock.unlock();
		}
	}

}
