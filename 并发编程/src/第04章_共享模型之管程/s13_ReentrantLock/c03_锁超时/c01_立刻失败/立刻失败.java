package ��04��_����ģ��֮�ܳ�.s13_ReentrantLock.c03_����ʱ.c01_����ʧ��;

import java.util.concurrent.locks.ReentrantLock;

import utils.Utils;

public class ����ʧ�� {

	public static void main(String[] args) {
		ReentrantLock lock = new ReentrantLock();
		Thread t1 = new Thread(() -> {
			Utils.log("����...");
			if (!lock.tryLock()) {
				Utils.log("��ȡ����ʧ�ܣ�����");
				return;
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
