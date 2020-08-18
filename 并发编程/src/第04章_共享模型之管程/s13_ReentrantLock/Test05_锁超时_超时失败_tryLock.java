package 第04章_共享模型之管程.s13_ReentrantLock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

import utils.Utils;

public class Test05_锁超时_超时失败_tryLock {
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
				Utils.log("释放了锁");
			}
		}, "t1");
		lock.lock();
		Utils.log("获得了锁");
		t1.start();
		try {
			//关键是调试这里
			Thread.sleep(500);
		} finally {
			lock.unlock();
			Utils.log("释放了锁");
		}
	}

}
