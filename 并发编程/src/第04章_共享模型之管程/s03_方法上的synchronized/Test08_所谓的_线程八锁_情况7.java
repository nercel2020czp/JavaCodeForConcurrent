package ��04��_����ģ��֮�ܳ�.s03_�����ϵ�synchronized;

import java.util.concurrent.TimeUnit;

import utils.Utils;

//���7��2 1s �� 1

class Number6 {
	public static synchronized void a() {
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Utils.log("1");
	}

	public synchronized void b() {
		Utils.log("2");
	}
}


public class Test08_��ν��_�̰߳���_���7 {
	//���7��2 1s �� 1������һ������
	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		Number6 n1 = new Number6();
		Number6 n2 = new Number6();
		new Thread(() -> {
			n1.a();
		}).start();
		new Thread(() -> {
			n2.b();
		}).start();
	}

}
