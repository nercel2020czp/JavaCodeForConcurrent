package ��04��_����ģ��֮�ܳ�.s13_ReentrantLock.c02_�ɴ��.c02_�����ж�ģʽ_interrupt;

import java.util.concurrent.locks.ReentrantLock;

import utils.Utils;

public class �����ж�ģʽ_interrupt {

	public static void main(String[] args) throws InterruptedException {
		ReentrantLock lock = new ReentrantLock();
		Thread t1 = new Thread(() -> {
			Utils.log("����...");
			lock.lock();
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
			Thread.sleep(5000);
			t1.interrupt();
			Utils.log("ִ�д��");
			Thread.sleep(5000);
		} finally {
			Utils.log("�ͷ�����");
			lock.unlock();
		}
	}

}
