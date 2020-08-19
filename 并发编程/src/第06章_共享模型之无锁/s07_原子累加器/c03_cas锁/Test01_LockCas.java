package ��06��_����ģ��֮����.s07_ԭ���ۼ���.c03_cas��;

import java.util.concurrent.atomic.AtomicInteger;

import utils.Utils;

//��Ҫ����ʵ��������
public class Test01_LockCas {
	private AtomicInteger state = new AtomicInteger(0);

	public void lock() {
		while (true) {
			if (state.compareAndSet(0, 1)) {
				break;
			}
		}
	}

	public void unlock() {
		Utils.log("unlock...");
		state.set(0);
	}

	public static void main(String[] args) {
		Test01_LockCas lock = new Test01_LockCas();
		new Thread(() -> {
			Utils.log("begin...");
			lock.lock();
			try {
				Utils.log("lock...");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} finally {
				lock.unlock();
			}
		}).start();
		
		
		new Thread(() -> {
			Utils.log("begin...");
			lock.lock();
			try {
				Utils.log("lock...");
			} finally {
				lock.unlock();
			}
		}).start();
	}
}
