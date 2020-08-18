package ��03��_Java_�߳�.s09_interrupt�������.s04_���park�߳�;

import java.util.concurrent.locks.LockSupport;

import utils.Utils;

public class c03_����ʹ��Thread_interrupted������״̬ {
	public static void main(String[] args) {
		test4();
	}
//	## isInterrupted() �ж��Ƿ񱻴�ϣ� ������� ��ϱ��
//	## interrupted() static �жϵ�ǰ�߳��Ƿ񱻴�� ����� ��ϱ��
	private static void test4() {
		Thread t1 = new Thread(() -> {
			for (int i = 0; i < 5; i++) {
				Utils.log("park...");
				LockSupport.park();
//				Thread.interrupted();
				Utils.log("���״̬�� " + Thread.interrupted());
			}
		});
		t1.start();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		t1.interrupt();
	}
}
