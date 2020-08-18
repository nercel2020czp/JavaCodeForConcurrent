package 第04章_共享模型之管程.s03_方法上的synchronized;
//2 1s 后 1
import java.util.concurrent.TimeUnit;

import utils.Utils;

//情况4：2 1s 后 1
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

public class Test05_所谓的_线程八锁_情况4 {
	////2 1s 后 1
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
