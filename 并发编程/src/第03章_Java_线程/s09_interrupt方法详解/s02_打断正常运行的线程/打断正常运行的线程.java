package 第03章_Java_线程.s09_interrupt方法详解.s02_打断正常运行的线程;

import utils.Utils;

public class 打断正常运行的线程 {
	public static void main(String[] args) {
		try {
			test2();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void test2() throws InterruptedException {
		Thread t2 = new Thread(() -> {
			while (true) {
				Thread current = Thread.currentThread();
				boolean interrupted = current.isInterrupted();
				if (interrupted) {
					Utils.log(" 打断状态: " + interrupted);
					break;
				}
			}
		}, "t2");
		t2.start();
		Thread.sleep(500);
		t2.interrupt();
	}
}
