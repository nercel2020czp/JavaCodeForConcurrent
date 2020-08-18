package ��04��_����ģ��֮�ܳ�.s12_��Ծ��.c03_����;

import utils.Utils;

public class Test01_TestLiveLock_������ʾ {
	static volatile int count = 10;
	static final Object lock = new Object();

	public static void main(String[] args) {
		new Thread(() -> {
			// �������� 0 �˳�ѭ��
			while (count > 0) {
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				count--;
				Utils.log("count:  " + count);
			}
		}, "t1").start();
		
		
		new Thread(() -> {
			// �������� 20 �˳�ѭ��
			while (count < 20) {
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				count++;
				Utils.log("count:  " + count);
			}
		}, "t2").start();
	}
}
