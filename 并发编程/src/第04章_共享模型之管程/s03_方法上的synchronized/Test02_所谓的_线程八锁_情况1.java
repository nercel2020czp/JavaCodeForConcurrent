package 第04章_共享模型之管程.s03_方法上的synchronized;

import utils.Utils;

class Number {
	public synchronized void a() {
		Utils.log("1");
	}

	public synchronized void b() {
		Utils.log("2");
	}
}

public class Test02_所谓的_线程八锁_情况1 {
	//1,2 或 2,1
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
