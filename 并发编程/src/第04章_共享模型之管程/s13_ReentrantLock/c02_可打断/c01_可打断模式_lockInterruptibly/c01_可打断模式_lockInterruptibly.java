package ��04��_����ģ��֮�ܳ�.s13_ReentrantLock.c02_�ɴ��.c01_�ɴ��ģʽ_lockInterruptibly;

import java.util.concurrent.locks.ReentrantLock;

import utils.Utils;

public class c01_�ɴ��ģʽ_lockInterruptibly {

	public static void main(String[] args) {
		ReentrantLock lock = new ReentrantLock();
		Thread t1 = new Thread(() -> {

			Utils.log("����...");
			try {
				lock.lockInterruptibly();
			} catch (InterruptedException e) {
				e.printStackTrace();
				Utils.log("�����Ĺ����б����");
				return;
			}
			try {
				Utils.log("�������");
			} finally {
				lock.unlock();
			}
		}, "t1");
		
		///////////////////////////////
		lock.lock();
		Utils.log("�������");
		t1.start();
		try {
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			t1.interrupt();
			Utils.log("ִ�д��");
		} finally {
			lock.unlock();
		}
	}

}
