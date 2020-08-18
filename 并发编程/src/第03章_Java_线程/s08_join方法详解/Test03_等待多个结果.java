package 第03章_Java_线程.s08_join方法详解;

import java.util.concurrent.TimeUnit;

import utils.Utils;

//问，下面代码 cost 大约多少秒？
public class Test03_等待多个结果 {
	static int r1 = 0;
	static int r2 = 0;

	public static void main(String[] args) throws InterruptedException {
		test2();
	}

	private static void test2() throws InterruptedException {
		Thread t1 = new Thread(() -> {
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			r1 = 10;
		});
		Thread t2 = new Thread(() -> {
			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			r2 = 20;
		});
		long start = System.currentTimeMillis();
		t1.start();
		t2.start();
		//注意将t2.join();与t1.join();顺序颠倒
		////Waits at most millis milliseconds for this thread to die
		t1.join();
		t2.join();
		long end = System.currentTimeMillis();
		Utils.log("r1: " + r1 + " r2: " + r2 + " cost: " + (end - start));
	}
/*	分析如下
	第一个 join：等待 t1 时, t2 并没有停止, 而在运行
	第二个 join：1s 后, 执行到此, t2 也运行了 1s, 因此也只需再等待 1s
	如果颠倒两个 join 呢？
	最终都是输出
	20:45:43.239 [main] c.TestJoin - r1: 10 r2: 20 cost: 2005*/
}
