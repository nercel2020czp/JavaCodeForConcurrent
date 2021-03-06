package 第04章_共享模型之管程.s03_方法上的synchronized;

import java.util.concurrent.TimeUnit;

import utils.Utils;

//情况7：2 1s 后 1

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


public class Test08_所谓的_线程八锁_情况7 {
	//情况7：2 1s 后 1【不是一把锁】
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
