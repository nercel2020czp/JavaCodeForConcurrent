package ��03��_Java_�߳�.s01_�����������߳�;

import utils.Utils;

/*
�ѡ��̡߳��͡����񡿣�Ҫִ�еĴ��룩�ֿ�
	Thread �����߳�
	Runnable �����е������߳�Ҫִ�еĴ��룩
	
		Runnable runnable = new Runnable() {
			public void run() {
				// Ҫִ�е�����
			}
		};
		// �����̶߳���
		Thread t = new Thread(runnable);
		// �����߳�
		t.start();
	
*/
public class Test02_������_ʹ��Runnable���Thread {
	public static void main(String[] args) {
		// �����������
		Runnable task2 = new Runnable() {
			@Override
			public void run() {
				Utils.log("hello");
			}
		};
		// ����1 ���������; ����2 ���߳����֣��Ƽ�
		Thread t2 = new Thread(task2, "t2");
		t2.start();
	}
}
