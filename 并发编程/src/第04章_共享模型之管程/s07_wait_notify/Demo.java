package ��04��_����ģ��֮�ܳ�.s07_wait_notify;

import java.util.concurrent.TimeUnit;

import utils.Utils;

public class Demo {
	final static Object obj = new Object();

	public static void main(String[] args) {
		new Thread(() -> {
			synchronized (obj) {
				Utils.log("ִ��....");
				try {
					obj.wait(); // ���߳���obj��һֱ�ȴ���ȥ
					//�ͻ��ͷ�����Դ
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				Utils.log("��������....");
			}
		}).start();
		new Thread(() -> {
			synchronized (obj) {
				Utils.log("ִ��....");
				try {
					obj.wait(); // ���߳���obj��һֱ�ȴ���ȥ
					//�ͻ��ͷ�����Դ
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				Utils.log("��������....");
			}
		}).start();
		// ���߳������ִ��
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Utils.log("���� obj �������߳�");
		synchronized (obj) {
//			obj.notify(); // ����obj��һ���߳�
			 obj.notifyAll(); // ����obj�����еȴ��߳�
		}
	}
}
