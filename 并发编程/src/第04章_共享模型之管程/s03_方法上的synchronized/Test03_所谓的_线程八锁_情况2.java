package ��04��_����ģ��֮�ܳ�.s03_�����ϵ�synchronized;

import java.util.concurrent.TimeUnit;
import utils.Utils;

class Number1 {
	public synchronized void a() {
		Utils.log("�������");
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Utils.log("1");
		Utils.log("�ͷ�����");
	}

	public synchronized void b() {
		Utils.log("�������");
		Utils.log("2");
		Utils.log("�ͷ�����");
	}

}



public class Test03_��ν��_�̰߳���_���2 {

	//1s��1,2���� 2 1s�� 1
	public static void main(String[] args) {
		Number1 n1 = new Number1();
		new Thread(() -> {
/*			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
			n1.a();
		}, "t1").start();
		new Thread(() -> {
			n1.b();
		}, "t2").start();
	}

}
