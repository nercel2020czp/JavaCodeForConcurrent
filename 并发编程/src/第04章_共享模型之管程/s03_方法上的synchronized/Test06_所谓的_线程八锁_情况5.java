package 第04章_共享模型之管程.s03_方法上的synchronized;
//情况5：2 1s 后 1
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
public class Test06_所谓的_线程八锁_情况5 {
	//情况5：2 1s 后 1【两个根本就不是一把锁】
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
