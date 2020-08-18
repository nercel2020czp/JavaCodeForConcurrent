package ��03��_Java_�߳�.s09_interrupt�������.s01_���sleep_wait_join���߳�;

import java.util.concurrent.TimeUnit;

import utils.Utils;

public class ���sleep_wait_join���߳� {
	
	public static void main(String[] args) {
		try {
			test1();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void test1() throws InterruptedException {
		Thread t1 = new Thread(() -> {
			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}, "t1");
		t1.start();
		TimeUnit.SECONDS.sleep(1);
		t1.interrupt();
		Utils.log(" ���״̬: " + t1.isInterrupted());
	}
}
