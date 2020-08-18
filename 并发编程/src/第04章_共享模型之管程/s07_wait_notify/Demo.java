package 第04章_共享模型之管程.s07_wait_notify;

import java.util.concurrent.TimeUnit;

import utils.Utils;

public class Demo {
	final static Object obj = new Object();

	public static void main(String[] args) {
		new Thread(() -> {
			synchronized (obj) {
				Utils.log("执行....");
				try {
					obj.wait(); // 让线程在obj上一直等待下去
					//就会释放锁资源
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				Utils.log("其它代码....");
			}
		}).start();
		new Thread(() -> {
			synchronized (obj) {
				Utils.log("执行....");
				try {
					obj.wait(); // 让线程在obj上一直等待下去
					//就会释放锁资源
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				Utils.log("其它代码....");
			}
		}).start();
		// 主线程两秒后执行
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Utils.log("唤醒 obj 上其它线程");
		synchronized (obj) {
//			obj.notify(); // 唤醒obj上一个线程
			 obj.notifyAll(); // 唤醒obj上所有等待线程
		}
	}
}
