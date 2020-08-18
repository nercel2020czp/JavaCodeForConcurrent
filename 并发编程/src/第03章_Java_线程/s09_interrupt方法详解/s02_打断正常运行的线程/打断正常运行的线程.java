package ��03��_Java_�߳�.s09_interrupt�������.s02_����������е��߳�;

import utils.Utils;

public class ����������е��߳� {
	public static void main(String[] args) {
		try {
			test2();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void test2() throws InterruptedException {
		Thread t2 = new Thread(() -> {
			while (true) {
				Thread current = Thread.currentThread();
				boolean interrupted = current.isInterrupted();
				if (interrupted) {
					Utils.log(" ���״̬: " + interrupted);
					break;
				}
			}
		}, "t2");
		t2.start();
		Thread.sleep(500);
		t2.interrupt();
	}
}
