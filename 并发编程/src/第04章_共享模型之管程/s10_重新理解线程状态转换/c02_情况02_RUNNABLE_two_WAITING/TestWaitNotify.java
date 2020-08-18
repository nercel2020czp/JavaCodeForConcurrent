package ��04��_����ģ��֮�ܳ�.s10_��������߳�״̬ת��.c02_���02_RUNNABLE_two_WAITING;

import utils.Utils;

public class TestWaitNotify {
	final static Object obj = new Object();

	public static void main(String[] args) {

		Thread t1 = new Thread(() -> {
			synchronized (obj) {
				Utils.log("ִ��....");
				try {
					obj.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				Utils.log("��������...."); // �ϵ�
//				while (true) {
//				}
			}
		}, "t1");
		t1.start();
		Thread t2 = new Thread(() -> {
			synchronized (obj) {
				Utils.log("ִ��....");
				try {
					obj.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				Utils.log("��������...."); // �ϵ�
//				while (true) {
//				}
			}
		}, "t2");
		t2.start();
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Utils.log("t1�̵߳�״̬Ϊ:" + t1.getState());
		Utils.log("t2�̵߳�״̬Ϊ:" + t2.getState());
		Utils.log("���� obj �������߳�");
		synchronized (obj) {
			obj.notify(); // ����obj�����еȴ��߳� �ϵ�
//			obj.notifyAll(); // ����obj�����еȴ��߳� �ϵ�

		}
		
		Utils.log("t1�̵߳�״̬Ϊ:" + t1.getState());
		Utils.log("t2�̵߳�״̬Ϊ:" + t2.getState());
	}
}
