package ��04��_����ģ��֮�ܳ�.s13_ReentrantLock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

import utils.Utils;

public class Test05_����ʱ_��ʱʧ��_tryLock {
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
				Utils.log("�ͷ�����");
			}
		}, "t1");
		lock.lock();
		Utils.log("�������");
		t1.start();
		try {
			//�ؼ��ǵ�������
			Thread.sleep(500);
		} finally {
			lock.unlock();
			Utils.log("�ͷ�����");
		}
	}

}
