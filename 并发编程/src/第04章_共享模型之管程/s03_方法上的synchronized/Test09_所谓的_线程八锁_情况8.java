package ��04��_����ģ��֮�ܳ�.s03_�����ϵ�synchronized;

import java.util.concurrent.TimeUnit;

import utils.Utils;

//���8��1s ��1��2�� �� 2 1s�� 1

class Number7 {
	public static synchronized void a() {
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Utils.log("1");
	}

	public static synchronized void b() {
		Utils.log("2");
	}
}

public class Test09_��ν��_�̰߳���_���8 {
	//���8��1s ��1��2�� �� 2 1s�� 1��ͬһ������
	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		Number7 n1 = new Number7();
		Number7 n2 = new Number7();
		new Thread(() -> {
			n1.a();
		}).start();
		new Thread(() -> {
			n2.b();
		}).start();
	}
}
