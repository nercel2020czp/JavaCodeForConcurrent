package ��04��_����ģ��֮�ܳ�.s12_��Ծ��.c01_����;

import utils.Utils;

//�������������һ���߳���Ҫͬʱ��ȡ���������ʱ�����׷�������
//t1 �߳� ��� A���� �������������ȡ B���� ���� t2 �߳� ��� B���� �������������ȡ A���� ���� ����
public class Test01_���� {
	public static void main(String[] args) {
		Object A = new Object();
		Object B = new Object();
		Thread t1 = new Thread(() -> {
			synchronized (A) {
				Utils.log("lock A");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				synchronized (B) {
					Utils.log("lock B");
					Utils.log("����...");
				}
			}
		}, "t1");
		Thread t2 = new Thread(() -> {
			synchronized (B) {
				Utils.log("lock B");
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				synchronized (A) {
					Utils.log("lock A");
					Utils.log("����...");
				}
			}
		}, "t2");
		t1.start();
		t2.start();
	}
}
