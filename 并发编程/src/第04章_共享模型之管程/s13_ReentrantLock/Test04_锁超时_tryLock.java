package 第04章_共享模型之管程.s13_ReentrantLock;
/*
tryLock    public boolean tryLock()

仅在调用时锁未被另一个线程保持的情况下，才获取该锁。 
 
1）如果该锁没有被另一个线程保持，并且立即返回 true 值，则将锁的保持计数设置为 1。
即使已将此锁设置为使用公平排序策略，但是调用 tryLock() 仍将 立即获取锁（如果有可用的），
而不管其他线程当前是否正在等待该锁。在某些情况下，此“闯入”行为可能很有用，即使它会打破公
平性也如此。如果希望遵守此锁的公平设置，则使用 tryLock(0, TimeUnit.SECONDS) 
，它几乎是等效的（也检测中断）。 
 
2）如果当前线程已经保持此锁，则将保持计数加 1，该方法将返回 true。 
 
3）如果锁被另一个线程保持，则此方法将立即返回 false 值。 
 
指定者：
   接口 Lock 中的  tryLock
返回： 
   如果锁是自由的并且被当前线程获取，或者当前线程已经保持该锁，则返回 true；否则返回 
false
*/
import java.util.concurrent.locks.ReentrantLock;

import utils.Utils;

public class Test04_锁超时_tryLock {
	public static void main(String[] args) throws InterruptedException {
		ReentrantLock lock = new ReentrantLock();
		Thread t1 = new Thread(() -> {
			Utils.log("启动...");
			if (!lock.tryLock()) {
				Utils.log("获取立刻失败，返回");
				return;
			}
			try {
				Utils.log("获得了锁");
			} finally {
				lock.unlock();
				Utils.log("释放了锁");
			}
		}, "t1");
		lock.lock();
		Utils.log("获得了锁");
		t1.start();
		try {
			Thread.sleep(3000);
		} finally {
			lock.unlock();
			Utils.log("释放了锁");
		}
	}
}
