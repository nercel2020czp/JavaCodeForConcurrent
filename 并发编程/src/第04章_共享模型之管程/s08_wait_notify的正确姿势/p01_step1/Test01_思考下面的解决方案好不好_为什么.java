package ��04��_����ģ��֮�ܳ�.s08_wait_notify����ȷ����.p01_step1;

import java.util.concurrent.TimeUnit;
import utils.Utils;

public class Test01_˼������Ľ�������ò���_Ϊʲô {

	static final Object room = new Object();
	static boolean hasCigarette = false;
	static boolean hasTakeout = false;
	
	public static void main(String[] args) {
		new Thread(() -> {
			synchronized (room) {
				Utils.log("����һ��Сʱ���е�����");
				Utils.log("����û�� " +  hasCigarette);
				if (!hasCigarette) {
					//���� synchronized (room) �󣬾ͺñ�С�������淴������˯����
					Utils.log("û�̣���Ъ�ᣡ");
					try {
						TimeUnit.SECONDS.sleep(5);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				Utils.log("����û��" + hasCigarette);
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
			// �����ܲ��ܼ� synchronized (room)��
			//main û��synchronized �ͺ��� main �߳��Ƿ�����������
//			synchronized (room) {
				hasCigarette = true;
				Utils.log("�̵����ޣ�");
//			}
		}, "���̵�").start();
		
	}
}
