package ��04��_����ģ��֮�ܳ�.s03_�����ϵ�synchronized;

import utils.Utils;

class Number {
	public synchronized void a() {
		Utils.log("1");
	}

	public synchronized void b() {
		Utils.log("2");
	}
}

public class Test02_��ν��_�̰߳���_���1 {
	//1,2 �� 2,1
	public static void main(String[] args) {
		Number n1 = new Number();
		new Thread(() -> {
			n1.a();
		}).start();
		new Thread(() -> {
			n1.b();
		}).start();
	}
}
