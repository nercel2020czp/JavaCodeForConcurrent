package ��04��_����ģ��֮�ܳ�.s03_�����ϵ�synchronized;
//���6��1s ��1��2�� �� 2 1s�� 1
import java.util.concurrent.TimeUnit;

import utils.Utils;

//Test06_��ν��_�̰߳���_���5

class Number5 {
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

public class Test07_��ν��_�̰߳���_���6 {
	//���6��1s ��1��2�� �� 2 1s�� 1
	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		//ͬһ����
		Number5 n1 = new Number5();
		new Thread(() -> {
			n1.a();
		}).start();
		new Thread(() -> {
			n1.b();
		}).start();
	}
}
