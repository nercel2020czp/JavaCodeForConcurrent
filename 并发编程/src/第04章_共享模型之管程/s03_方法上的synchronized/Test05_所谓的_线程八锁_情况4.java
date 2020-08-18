package ��04��_����ģ��֮�ܳ�.s03_�����ϵ�synchronized;
//2 1s �� 1
import java.util.concurrent.TimeUnit;

import utils.Utils;

//���4��2 1s �� 1
class Number3 {
	public synchronized void a() {
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

public class Test05_��ν��_�̰߳���_���4 {
	////2 1s �� 1
	public static void main(String[] args) {
		Number3 n1 = new Number3();
		Number3 n2 = new Number3();
		new Thread(() -> {
			n1.a();
		}).start();
		new Thread(() -> {
			n2.b();
		}).start();
	}
}
