package 第04章_共享模型之管程.s13_ReentrantLock.c04_公平锁;
/*强行插入，有机会在中间输出
注意：该实验不一定总能复现
公平锁一般没有必要，会降低并发度，后面分析原理时会讲解
-------------------------------------------------------
公平锁
    是指多个线程按照申请锁的顺序来获取锁类似排队打饭 先来后到
非公平锁
    是指在多线程获取锁的顺序并不是按照申请锁的顺序,有可能后申请的线程比先
    申请的线程优先获取到锁,在高并发的情况下,有可能造成优先级反转或者饥饿现象
-------------------------------------------------------
公平锁/非公平锁
  并发包ReentrantLock的创建可以指定构造函数的boolean类型来得到公平锁或者非公平锁 默认是非公平锁
【见图  公平锁和非公平锁.png】
-------------------------------------------------------
Java ReentrantLock而言,
	通过构造哈数指定该锁是否是公平锁 默认是非公平锁 非公平锁的优点在于吞吐量必公平锁大.
 
 
对于synchronized而言 也是一种非公平锁.


*/
import java.util.concurrent.locks.ReentrantLock;

import utils.Utils;

//ReentrantLock 默认是不公平的
public class Test01_公平锁 {
	public static void main(String[] args) throws InterruptedException {
		//false默认是非公平锁
//		ReentrantLock lock = new ReentrantLock(false);
		//改为公平锁后
		ReentrantLock lock = new ReentrantLock(true);
		lock.lock();
		for (int i = 0; i < 10; i++) {
			new Thread(() -> {
				lock.lock();
				try {
					Utils.log("running...");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} finally {
					lock.unlock();
				}
			}, "t" + i).start();
		}
		
		// 1s 之后去争抢锁
		Thread.sleep(1000);
		
		new Thread(() -> {
			Utils.log("start...");
			lock.lock();
			try {
				Utils.log("running...");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} finally {
				lock.unlock();
			}
		}, "强行插入").start();
		lock.unlock();
	}
}
