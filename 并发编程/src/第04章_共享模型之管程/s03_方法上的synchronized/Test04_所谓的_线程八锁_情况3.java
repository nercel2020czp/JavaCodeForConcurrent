package 第04章_共享模型之管程.s03_方法上的synchronized;

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

public class Test04_所谓的_线程八锁_情况3 {

	public static void main(String[] args) {
		//3 1s 1,2 或 2,3 1s 1 或 3,2 1s 1
		Number2 n1 = new Number2();
		new Thread(()->{ n1.a(); }).start();
		new Thread(()->{ n1.b(); }).start();
		new Thread(()->{ n1.c(); }).start();
		
	}

}
