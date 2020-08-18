package p03_同步模式之顺序控制.s2_交替输出.s1_wait_notify_版;

import java.util.concurrent.TimeUnit;

import utils.Utils;

public class SyncWaitNotify {
	private int flag;
	private int loopNumber;

	public SyncWaitNotify(int flag, int loopNumber) {
		this.flag = flag;
		this.loopNumber = loopNumber;
	}

	public void print(int waitFlag, int nextFlag, String str) {
		for (int i = 0; i < loopNumber; i++) {
			synchronized (this) {
				while (this.flag != waitFlag) {
					try {
						this.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Utils.log(str);
				flag = nextFlag;
				this.notifyAll();
			}
		}
	}
	
	public static void main(String[] args) {
		SyncWaitNotify syncWaitNotify = new SyncWaitNotify(1, 5);
		new Thread(() -> {
			syncWaitNotify.print(1, 2, "a");
		}).start();
		new Thread(() -> {
			syncWaitNotify.print(2, 3, "b");
		}).start();
		new Thread(() -> {
			syncWaitNotify.print(3, 1, "c");
		}).start();
	}
}
