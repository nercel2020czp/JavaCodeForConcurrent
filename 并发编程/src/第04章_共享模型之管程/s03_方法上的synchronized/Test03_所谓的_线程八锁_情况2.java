package 第04章_共享模型之管程.s03_方法上的synchronized;

import java.util.concurrent.TimeUnit;
import utils.Utils;

class Number1 {
	public synchronized void a() {
		Utils.log("获得了锁");
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Utils.log("1");
		Utils.log("释放了锁");
	}

	public synchronized void b() {
		Utils.log("获得了锁");
		Utils.log("2");
		Utils.log("释放了锁");
	}

}



public class Test03_所谓的_线程八锁_情况2 {

	//1s后1,2，或 2 1s后 1
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
