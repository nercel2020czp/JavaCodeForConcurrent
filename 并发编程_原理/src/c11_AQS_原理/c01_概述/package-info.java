/**
 * 
 */
/**
 * @author 15753
 *
 */
package c11_AQS_原理.c01_概述;

/*

1. 概述
	全称是 AbstractQueuedSynchronizer，是阻塞式锁和相关的同步器工具的框架
	
特点：
	1. 用 state 属性来表示资源的状态（分独占模式和共享模式），子类需要定义如何维护这个状态，控制如何获取锁和释放锁
		getState - 获取 state 状态
		setState - 设置 state 状态
		compareAndSetState - cas 机制设置 state 状态
		独占模式是只有一个线程能够访问资源，而共享模式可以允许多个线程访问资源

	2. 提供了基于 FIFO 的等待队列，类似于 Monitor 的 EntryList
	
	3. 条件变量来实现等待、唤醒机制，支持多个条件变量，类似于 Monitor 的 WaitSet
	
子类主要实现这样一些方法（默认抛出 UnsupportedOperationException）
	tryAcquire
	tryRelease
	tryAcquireShared
	tryReleaseShared
	isHeldExclusively
	
获取锁的姿势:
	// 如果获取锁失败
	if (!tryAcquire(arg)) {
		// 入队, 可以选择阻塞当前线程 park unpark
	}

释放锁的姿势:
	// 如果释放锁成功
	if (tryRelease(arg)) {
		// 让阻塞线程恢复运行
	}


*/