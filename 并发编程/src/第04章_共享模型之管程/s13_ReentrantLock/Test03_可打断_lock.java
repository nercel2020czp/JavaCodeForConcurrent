package 第04章_共享模型之管程.s13_ReentrantLock;

/*lock
public void lock()
获取锁。
如果该锁没有被另一个线程保持，则获取该锁并立即返回，将锁的保持计数设置为 1。
如果当前线程已经保持该锁，则将保持计数加 1，并且该方法立即返回。
如果该锁被另一个线程保持，则出于线程调度的目的，禁用当前线程，并且在获得锁之前，该线程将一
直处于休眠状态，此时锁保持计数被设置为 1。
 
指定者：
接口 Lock 中的 lock
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

public class Test03_可打断_lock {
	public static void main(String[] args) throws InterruptedException {
		ReentrantLock lock = new ReentrantLock();
		Thread t1 = new Thread(() -> {
			Utils.log("启动...");
			//lock 优先考虑获取锁，待获取锁成功后，才响应中断。
			lock.lock();
			try {
				Utils.log("获得了锁");
			} finally {
				Utils.log("释放了锁...");
				lock.unlock();
			}
			Utils.log("释放锁后...");
		}, "t1");
		lock.lock();
		Utils.log("获得了锁");
		t1.start();
		try {
/*		    ReentrantLock.lock方法不允许Thread.interrupt中断,即使检测
            到Thread.isInterrupted,一样会继续尝试获取锁，失败则继续休眠。
            只是在最后获取锁成功后再把当前线程置为interrupted状态,然后再中断线程。*/
			Thread.sleep(3000);
			Utils.log("执行打断");
			t1.interrupt();//这时 t1 并没有被真正打断, 而是仍继续等待锁
			Utils.log("打断成功");
			Thread.sleep(3000);
		} finally {
			Utils.log("释放了锁");
			lock.unlock();
		}
	}
}
