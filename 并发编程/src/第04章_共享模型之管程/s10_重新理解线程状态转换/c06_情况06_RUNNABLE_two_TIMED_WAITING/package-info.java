/**
 * 
 */
/**
 * @author 15753
 *
 */
package 第04章_共享模型之管程.s10_重新理解线程状态转换.c06_情况06_RUNNABLE_two_TIMED_WAITING;
/*

情况 6 RUNNABLE <--> TIMED_WAITING
	当前线程调用 t.join(long n) 方法时，当前线程从 RUNNABLE --> TIMED_WAITING
		注意是当前线程在t 线程对象的监视器上等待
	当前线程等待时间超过了 n 毫秒，或t 线程运行结束，或调用了当前线程的 interrupt() 时，当前线程从
		TIMED_WAITING --> RUNNABLE

https://www.cnblogs.com/gosaint/p/9111189.html
	
综上所述，我们分别介绍了不同种线程的不同状态下对于中断请求的反应。
NEW和TERMINATED对于中断操作几乎是屏蔽的，RUNNABLE和BLOCKED类似，
对于中断操作只是设置中断标志位并没有强制终止线程，对于线程的终止权利依然在程序手中。
WAITING/TIMED_WAITING状态下的线程对于中断操作是敏感的，他们会抛出异常并清空中断标志位。
*/