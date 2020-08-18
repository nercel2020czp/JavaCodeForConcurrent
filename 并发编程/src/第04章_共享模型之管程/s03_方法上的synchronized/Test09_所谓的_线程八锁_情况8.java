package 第04章_共享模型之管程.s03_方法上的synchronized;

import java.util.concurrent.TimeUnit;

import utils.Utils;

//情况8：1s 后1，2； 或 2 1s后 1

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

public class Test09_所谓的_线程八锁_情况8 {
	//情况8：1s 后1，2， 或 2 1s后 1【同一把锁】
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
