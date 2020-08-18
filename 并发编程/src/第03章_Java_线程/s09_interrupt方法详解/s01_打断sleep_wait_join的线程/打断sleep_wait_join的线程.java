package 第03章_Java_线程.s09_interrupt方法详解.s01_打断sleep_wait_join的线程;

import java.util.concurrent.TimeUnit;

import utils.Utils;

public class 打断sleep_wait_join的线程 {
	
	public static void main(String[] args) {
		try {
			test1();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void test1() throws InterruptedException {
		Thread t1 = new Thread(() -> {
			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}, "t1");
		t1.start();
		TimeUnit.SECONDS.sleep(1);
		t1.interrupt();
		Utils.log(" 打断状态: " + t1.isInterrupted());
	}
}
