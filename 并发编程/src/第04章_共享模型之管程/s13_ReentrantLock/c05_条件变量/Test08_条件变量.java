package ��04��_����ģ��֮�ܳ�.s13_ReentrantLock.c05_��������;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

import utils.Utils;

public class Test08_�������� {
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
				Utils.log("�ȵ���������");
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
				Utils.log("�ȵ����������");
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
			Utils.log("��������");
			hasCigrette = true;
			waitCigaretteQueue.signal();
		} finally {
			lock.unlock();
		}
	}

	private static void sendBreakfast() {
		lock.lock();
		try {
			Utils.log("���������");
			hasBreakfast = true;
			waitbreakfastQueue.signal();
		} finally {
			lock.unlock();
		}
	}
}
