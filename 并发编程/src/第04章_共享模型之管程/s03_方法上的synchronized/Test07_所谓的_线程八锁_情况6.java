package 第04章_共享模型之管程.s03_方法上的synchronized;
//情况6：1s 后1，2， 或 2 1s后 1
import java.util.concurrent.TimeUnit;

import utils.Utils;

//Test06_所谓的_线程八锁_情况5

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

public class Test07_所谓的_线程八锁_情况6 {
	//情况6：1s 后1，2， 或 2 1s后 1
	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		//同一把锁
		Number5 n1 = new Number5();
		new Thread(() -> {
			n1.a();
		}).start();
		new Thread(() -> {
			n1.b();
		}).start();
	}
}
