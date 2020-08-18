package 第04章_共享模型之管程.s10_重新理解线程状态转换.c02_情况02_RUNNABLE_two_WAITING;

import utils.Utils;

public class TestWaitNotify {
	final static Object obj = new Object();

	public static void main(String[] args) {

		Thread t1 = new Thread(() -> {
			synchronized (obj) {
				Utils.log("执行....");
				try {
					obj.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				Utils.log("其它代码...."); // 断点
//				while (true) {
//				}
			}
		}, "t1");
		t1.start();
		Thread t2 = new Thread(() -> {
			synchronized (obj) {
				Utils.log("执行....");
				try {
					obj.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				Utils.log("其它代码...."); // 断点
//				while (true) {
//				}
			}
		}, "t2");
		t2.start();
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Utils.log("t1线程的状态为:" + t1.getState());
		Utils.log("t2线程的状态为:" + t2.getState());
		Utils.log("唤醒 obj 上其它线程");
		synchronized (obj) {
			obj.notify(); // 唤醒obj上所有等待线程 断点
//			obj.notifyAll(); // 唤醒obj上所有等待线程 断点

		}
		
		Utils.log("t1线程的状态为:" + t1.getState());
		Utils.log("t2线程的状态为:" + t2.getState());
	}
}
