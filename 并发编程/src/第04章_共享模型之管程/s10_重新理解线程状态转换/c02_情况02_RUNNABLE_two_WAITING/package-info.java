/**
 * 
 */
/**
 * @author 15753
 *
 */
package 第04章_共享模型之管程.s10_重新理解线程状态转换.c02_情况02_RUNNABLE_two_WAITING;
/*
情况 2 RUNNABLE <--> WAITING
	t 线程用 synchronized(obj) 获取了对象锁后
		调用 obj.wait() 方法时，t 线程从 RUNNABLE --> WAITING
		调用 obj.notify() ， obj.notifyAll() ， t.interrupt() 时
			竞争锁成功，t 线程从 WAITING --> RUNNABLE
			竞争锁失败，t 线程从 WAITING --> BLOCKED



*/