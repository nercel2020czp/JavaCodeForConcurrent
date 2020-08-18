package ��03��_Java_�߳�.s09_interrupt�������.s04_���park�߳�;

import java.util.concurrent.locks.LockSupport;

import utils.Utils;

public class c01_���park�߳�_������մ��״̬ {
	
	public static void main(String[] args) {
		try {
			test3();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		2020��08��16��  - 08:19:07.346 - t1 - park...
//		2020��08��16��  - 08:19:07.843 - t1 - unpark...
//		2020��08��16��  - 08:19:07.843 - t1 - ���״̬�� true
	}
	
	private static void test3() throws InterruptedException {
		Thread t1 = new Thread(() -> {
			Utils.log("park...");
			LockSupport.park();
			Utils.log("unpark...");
			Utils.log("���״̬�� " + Thread.currentThread().isInterrupted());
		}, "t1");
		t1.start();
		Thread.sleep(5000);
		t1.interrupt();
	}
}
