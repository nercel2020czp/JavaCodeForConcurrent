package ��03��_Java_�߳�.s08_join�������;

import java.util.concurrent.TimeUnit;

import utils.Utils;

public class Test05_��ʱЧ��join_û�еȹ�ʱ�� {
	static int r1 = 0;
	static int r2 = 0;

	public static void main(String[] args) throws InterruptedException {
		test3();
	}

	public static void test3() throws InterruptedException {
		Thread t1 = new Thread(() -> {
			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			r1 = 10;
		});
		long start = System.currentTimeMillis();
		t1.start();
		// �߳�ִ�н����ᵼ�� join ����
		////Waits at most millis milliseconds for this thread to die
		t1.join(1500);
		long end = System.currentTimeMillis();
		Utils.log("r1: " + r1 + " r2: " + r2 + " cost: " + (end - start));
	}
}
