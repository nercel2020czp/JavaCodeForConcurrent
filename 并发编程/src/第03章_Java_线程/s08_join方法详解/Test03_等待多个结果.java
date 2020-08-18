package ��03��_Java_�߳�.s08_join�������;

import java.util.concurrent.TimeUnit;

import utils.Utils;

//�ʣ�������� cost ��Լ�����룿
public class Test03_�ȴ������� {
	static int r1 = 0;
	static int r2 = 0;

	public static void main(String[] args) throws InterruptedException {
		test2();
	}

	private static void test2() throws InterruptedException {
		Thread t1 = new Thread(() -> {
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			r1 = 10;
		});
		Thread t2 = new Thread(() -> {
			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			r2 = 20;
		});
		long start = System.currentTimeMillis();
		t1.start();
		t2.start();
		//ע�⽫t2.join();��t1.join();˳��ߵ�
		////Waits at most millis milliseconds for this thread to die
		t1.join();
		t2.join();
		long end = System.currentTimeMillis();
		Utils.log("r1: " + r1 + " r2: " + r2 + " cost: " + (end - start));
	}
/*	��������
	��һ�� join���ȴ� t1 ʱ, t2 ��û��ֹͣ, ��������
	�ڶ��� join��1s ��, ִ�е���, t2 Ҳ������ 1s, ���Ҳֻ���ٵȴ� 1s
	����ߵ����� join �أ�
	���ն������
	20:45:43.239 [main] c.TestJoin - r1: 10 r2: 20 cost: 2005*/
}
