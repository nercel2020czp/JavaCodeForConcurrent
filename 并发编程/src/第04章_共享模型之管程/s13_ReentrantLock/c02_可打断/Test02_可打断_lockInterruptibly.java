package 第04章_共享模型之管程.s13_ReentrantLock.c02_可打断;
/*
lockInterruptibly
public void lockInterruptibly() throws InterruptedException
1）如果当前线程未被中断，则获取锁。 
2）如果该锁没有被另一个线程保持，则获取该锁并立即返回，将锁的保持计数设置为 1。 
3）如果当前线程已经保持此锁，则将保持计数加 1，并且该方法立即返回。 
4）如果锁被另一个线程保持，则出于线程调度目的，禁用当前线程，并且在发生以下两种情况之一以
前，该线程将一直处于休眠状态： 
     1）锁由当前线程获得；或者 
     2）其他某个线程中断当前线程。 
5）如果当前线程获得该锁，则将锁保持计数设置为 1。 如果当前线程： 
	 1）在进入此方法时已经设置了该线程的中断状态；或者 
	 2）在等待获取锁的同时被中断。 
   则抛出 InterruptedException，并且清除当前线程的已中断状态。 
 
6）在此实现中，因为此方法是一个显式中断点，所以要优先考虑响应中断，而不是响应锁的普通获取或
重入获取。 
	指定者： 接口 Lock 中的 lockInterruptibly
	抛出：   InterruptedException   如果当前线程已中断。

*/
/*lock()与lockInterruptibly()的区别

lock 与 lockInterruptibly比较区别在于：
	1.lock 优先考虑获取锁，待获取锁成功后，才响应中断。
	2.lockInterruptibly 优先考虑响应中断，而不是响应锁的普通获取或重入获取。

详细区别：
	1.ReentrantLock.lockInterruptibly允许在等待时由其它线程调用
	     等待线程的Thread.interrupt方法来中断等待线程的等待而直接返回，
	     这时不用获取锁，而会抛出一个InterruptedException。
	     
    2.ReentrantLock.lock方法不允许Thread.interrupt中断,即使检测
              到Thread.isInterrupted,一样会继续尝试获取锁，失败则继续休眠。
              只是在最后获取锁成功后再把当前线程置为interrupted状态,然后再中断线程。

 */
import java.util.concurrent.locks.ReentrantLock;

import utils.Utils;

public class Test02_可打断_lockInterruptibly {
	public static void main(String[] args) throws InterruptedException {
		ReentrantLock lock = new ReentrantLock();
		Thread t1 = new Thread(() -> {
			Utils.log("启动...");
			try {
				//lockInterruptibly 优先考虑响应中断，而不是响应锁的普通获取或重入获取。
/*				4）如果锁被另一个线程【main】保持，则出于线程调度目的，禁用当前线程，并且在发生以下两种情况之一以
				前，该线程将一直处于休眠状态： 
				     1）锁由当前线程获得；或者 
				     2）其他某个线程中断当前线程。 */
				lock.lockInterruptibly();
			} catch (InterruptedException e) {
				e.printStackTrace();
				Utils.log("等锁的过程中被打断");
				return;
			}
			try {
				Utils.log("获得了锁");
			} finally {
//				lock.unlock();
				Utils.log("释放了锁");
			}
			Utils.log("释放锁后...");
		}, "t1");
		lock.lock();
		Utils.log("获得了锁");
		t1.start();
		try {
/*			1.ReentrantLock.lockInterruptibly允许在等待时由其它线程调用
		     等待线程的Thread.interrupt方法来中断等待线程的等待而直接返回，
		     这时不用获取锁，而会抛出一个InterruptedException。*/
			Thread.sleep(3000);
			Utils.log("执行打断...");
			t1.interrupt();//1) 如果当前线程未被中断，则获取锁。 
			Utils.log("打断成功...");
		} finally {
			Utils.log("释放锁...");
			lock.unlock();
		}
	}
}
