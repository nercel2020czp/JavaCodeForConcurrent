package ��04��_����ģ��֮�ܳ�.s08_wait_notify����ȷ����.p02_step2;

import java.util.concurrent.TimeUnit;

import utils.Utils;

public class Test02_˼�������ʵ������_Ϊʲô {
	
/*	����������ɻ���߳�����������
	������������߳�Ҳ�ڵȴ������أ�*/
	
	static final Object room = new Object();
	static boolean hasCigarette = false;
	static boolean hasTakeout = false;
	public static void main(String[] args) {
		
		new Thread(() -> {
			synchronized (room) {
				Utils.log("����û�� " + hasCigarette);
				if (!hasCigarette) {
					Utils.log("û�̣���Ъ�ᣡ");
					try {
						room.wait(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				Utils.log("����û�� " + hasCigarette);
				if (hasCigarette) {
					Utils.log("���Կ�ʼ�ɻ���");
				}
			}
		}, "С��").start();
		
		for (int i = 0; i < 5; i++) {
			new Thread(() -> {
				synchronized (room) {
					Utils.log("���Կ�ʼ�ɻ���");
				}
			}, "������").start();
		}
		
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		new Thread(() -> {
			synchronized (room) {
				hasCigarette = true;
				Utils.log("�̵����ޣ�");
				room.notify();
			}
		}, "���̵�").start();
		
	}
}
