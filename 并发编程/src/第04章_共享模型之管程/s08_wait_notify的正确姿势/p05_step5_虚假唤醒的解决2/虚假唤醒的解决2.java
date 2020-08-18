package ��04��_����ģ��֮�ܳ�.s08_wait_notify����ȷ����.p05_step5_��ٻ��ѵĽ��2;

import java.util.concurrent.TimeUnit;

import utils.Utils;

public class ��ٻ��ѵĽ��2 {
	static final Object room = new Object();
	static boolean hasCigarette = false;
	static boolean hasTakeout = false;
	public static void main(String[] args) {
		
		new Thread(() -> {
			synchronized (room) {
				Utils.log("����û�� " + hasCigarette);
				while (!hasCigarette) {
					Utils.log("û�̣���Ъ�ᣡ");
					try {
						room.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				Utils.log("����û�� " + hasCigarette);
				if (hasCigarette) {
					Utils.log("���Կ�ʼ�ɻ���");
				}else {
					Utils.log("�ɲ��ɻ���");
				}
			}
		}, "С��").start();
		
		new Thread(() -> {
			synchronized (room) {
				Utils.log("������û�� " + hasTakeout);
				while (!hasTakeout) {
					Utils.log("������û������Ъ�ᣡ");
					try {
						room.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				Utils.log("������û�� " + hasTakeout);
				if (hasTakeout) {
					Utils.log("���Կ�ʼ�ɻ���");
				}else {
					Utils.log("�ɲ��ɻ���");
				}
			}
		}, "СŮ").start();
		
		
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		new Thread(() -> {
			synchronized (room) {
				hasTakeout = true;
				Utils.log("���������ޣ�");
				room.notifyAll();
			}
		}, "��������").start();
		
	}
}
