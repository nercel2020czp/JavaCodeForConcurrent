/**
 * 
 */
/**
 * @author 15753
 *
 */
package 第04章_共享模型之管程.s13_ReentrantLock.c02_可打断.c01_可打断模式_lockInterruptibly;

/*

2020年08月16日  - 15:06:15.994 - main - 获得了锁
2020年08月16日  - 15:06:16.054 - t1 - 启动...
2020年08月16日  - 15:06:26.054 - main - 执行打断
java.lang.InterruptedException
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.doAcquireInterruptibly(Unknown Source)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.acquireInterruptibly(Unknown Source)
	at java.util.concurrent.locks.ReentrantLock.lockInterruptibly(Unknown Source)
	at 第04章_共享模型之管程.s13_ReentrantLock.c02_可打断.c01_可打断.lambda$0(c01_可打断.java:15)
	at java.lang.Thread.run(Unknown Source)
2020年08月16日  - 15:06:26.124 - t1 - 等锁的过程中被打断



*/