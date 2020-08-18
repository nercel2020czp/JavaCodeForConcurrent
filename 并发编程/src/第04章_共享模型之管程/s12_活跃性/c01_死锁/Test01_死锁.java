package 第04章_共享模型之管程.s12_活跃性.c01_死锁;

import utils.Utils;

//有这样的情况：一个线程需要同时获取多把锁，这时就容易发生死锁
//t1 线程 获得 A对象 锁，接下来想获取 B对象 的锁 t2 线程 获得 B对象 锁，接下来想获取 A对象 的锁 例：
public class Test01_死锁 {
	public static void main(String[] args) {
		Object A = new Object();
		Object B = new Object();
		Thread t1 = new Thread(() -> {
			synchronized (A) {
				Utils.log("lock A");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				synchronized (B) {
					Utils.log("lock B");
					Utils.log("操作...");
				}
			}
		}, "t1");
		Thread t2 = new Thread(() -> {
			synchronized (B) {
				Utils.log("lock B");
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				synchronized (A) {
					Utils.log("lock A");
					Utils.log("操作...");
				}
			}
		}, "t2");
		t1.start();
		t2.start();
	}
}
