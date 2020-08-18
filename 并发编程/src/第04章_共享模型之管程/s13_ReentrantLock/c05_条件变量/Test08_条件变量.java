package 第04章_共享模型之管程.s13_ReentrantLock.c05_条件变量;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

import utils.Utils;

public class Test08_条件变量 {
	static ReentrantLock lock = new ReentrantLock();
	static Condition waitCigaretteQueue = lock.newCondition();
	static Condition waitbreakfastQueue = lock.newCondition();
	static volatile boolean hasCigrette = false;
	static volatile boolean hasBreakfast = false;

	public static void main(String[] args) throws InterruptedException {
		new Thread(() -> {
			try {
				lock.lock();
				while (!hasCigrette) {
					try {
						waitCigaretteQueue.await();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				Utils.log("等到了它的烟");
			} finally {
				lock.unlock();
			}
		}).start();

		new Thread(() -> {
			try {
				lock.lock();
				while (!hasBreakfast) {
					try {
						waitbreakfastQueue.await();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				Utils.log("等到了它的早餐");
			} finally {
				lock.unlock();
			}
		}).start();

		TimeUnit.SECONDS.sleep(5);
		sendBreakfast();
		TimeUnit.SECONDS.sleep(5);
		sendCigarette();
	}

	private static void sendCigarette() {
		lock.lock();
		try {
			Utils.log("送烟来了");
			hasCigrette = true;
			waitCigaretteQueue.signal();
		} finally {
			lock.unlock();
		}
	}

	private static void sendBreakfast() {
		lock.lock();
		try {
			Utils.log("送早餐来了");
			hasBreakfast = true;
			waitbreakfastQueue.signal();
		} finally {
			lock.unlock();
		}
	}
}
