package ��03��_Java_�߳�.s09_interrupt�������.s04_���park�߳�;
//��� park �߳�, ������մ��״̬
//�����ϱ���Ѿ��� true, �� park ��ʧЧ
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

import utils.Utils;

public class Test03_���park�߳� {
	public static void main(String[] args) {
		test3();
//		test4();
	}
	
	//��� park �߳�, ������մ��״̬
	private static void test3() {
		Thread t1 = new Thread(() -> {
			Utils.log("park...");
			LockSupport.park();
			Utils.log("unpark...");
			Utils.log("���״̬��" + Thread.interrupted());
			//��� park �߳�, ������մ��״̬
			//�����ϱ���Ѿ��� true, �� park ��ʧЧ
			//���´���Ͳ���ִ����
			LockSupport.park();
			Utils.log("unpark...");
		}, "t1");
		t1.start();
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		t1.interrupt();
	}
	//�����ϱ���Ѿ��� true, �� park ��ʧЧ
	private static void test4() {
		Thread t1 = new Thread(() -> {
			for (int i = 0; i < 5; i++) {
				Utils.log("park...");
				LockSupport.park();
				Utils.log("���״̬��" + Thread.currentThread().isInterrupted());
			}
		});
		t1.start();
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		t1.interrupt();
	}
}
