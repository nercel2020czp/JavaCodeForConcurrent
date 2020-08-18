/**
 * 
 */
/**
 * @author 15753
 *
 */
package 第04章_共享模型之管程.s10_重新理解线程状态转换.c05_情况05_RUNNABLE_two_TIMED_WAITING;
/*

情况 5 RUNNABLE <--> TIMED_WAITING

t 线程用 synchronized(obj) 获取了对象锁后
	调用 obj.wait(long n) 方法时，t 线程从 RUNNABLE --> TIMED_WAITING
	t 线程等待时间超过了 n 毫秒，或调用 obj.notify() ， obj.notifyAll() ， t.interrupt() 时
		竞争锁成功，t 线程从 TIMED_WAITING --> RUNNABLE
		竞争锁失败，t 线程从 TIMED_WAITING --> BLOCKED

https://www.cnblogs.com/gosaint/p/9111189.html
	
综上所述，我们分别介绍了不同种线程的不同状态下对于中断请求的反应。
NEW和TERMINATED对于中断操作几乎是屏蔽的，RUNNABLE和BLOCKED类似，
对于中断操作只是设置中断标志位并没有强制终止线程，对于线程的终止权利依然在程序手中。
WAITING/TIMED_WAITING状态下的线程对于中断操作是敏感的，他们会抛出异常并清空中断标志位。
*/