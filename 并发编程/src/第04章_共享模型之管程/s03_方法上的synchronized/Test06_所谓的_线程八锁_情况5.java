package ��04��_����ģ��֮�ܳ�.s03_�����ϵ�synchronized;
//���5��2 1s �� 1
import java.util.concurrent.TimeUnit;

import utils.Utils;


class Number4 {
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
public class Test06_��ν��_�̰߳���_���5 {
	//���5��2 1s �� 1�����������Ͳ���һ������
	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		Number4 n1 = new Number4();
		new Thread(() -> {
			n1.a();
		}).start();
		new Thread(() -> {
			n1.b();
		}).start();
	}
}
