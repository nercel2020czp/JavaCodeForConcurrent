package ��04��_����ģ��֮�ܳ�.s03_�����ϵ�synchronized;

import java.util.concurrent.TimeUnit;

import utils.Utils;

class Number2 {
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

	public void c() {
		Utils.log("3");
	}
}

public class Test04_��ν��_�̰߳���_���3 {

	public static void main(String[] args) {
		//3 1s 1,2 �� 2,3 1s 1 �� 3,2 1s 1
		Number2 n1 = new Number2();
		new Thread(()->{ n1.a(); }).start();
		new Thread(()->{ n1.b(); }).start();
		new Thread(()->{ n1.c(); }).start();
		
	}

}
