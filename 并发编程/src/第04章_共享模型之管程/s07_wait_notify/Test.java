package 第04章_共享模型之管程.s07_wait_notify;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Test {
	static volatile boolean flag = true;

	public static void main(String[] args) {
		Object o1 = new Object();
		Lock lock = new ReentrantLock(true);
		String s1 = "123456789";
		String s2 = "ABCDE";
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < s1.length(); i++) {
					if (i > s2.length()) {
						flag = true;
					}
					lock.lock();
					try {
						if (flag) {
							System.out.print(s1.charAt(i));
							flag = false;
						}
					} finally {
						lock.unlock();
					}

				}
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < s2.length(); i++) {
					lock.lock();
					try {
						if (!flag) {
							System.out.print(s2.charAt(i));
							flag = true;
						}
					} finally {
						lock.unlock();
					}

				}
			}
		});
		t1.start();
		t2.start();
	}
}
