package ��04��_����ģ��֮�ܳ�.s13_ReentrantLock.c03_����ʱ.c02_��ʱʧ��;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

import utils.Utils;

public class Test01_��ʱʧ�� {

	public static void main(String[] args) throws InterruptedException {
		ReentrantLock lock = new ReentrantLock();
		Thread t1 = new Thread(() -> {
			Utils.log("����...");
			try {
				if (!lock.tryLock(1, TimeUnit.SECONDS)) {
					Utils.log("��ȡ�ȴ� 1s ��ʧ�ܣ�����");
					return;
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			try {
				Utils.log("�������");
			} finally {
				lock.unlock();
			}
		}, "t1");
		
		
		lock.lock();
		Utils.log("�������");
		t1.start();
		try {
			Thread.sleep(2000);
		} finally {
			lock.unlock();
		}
	}

}
