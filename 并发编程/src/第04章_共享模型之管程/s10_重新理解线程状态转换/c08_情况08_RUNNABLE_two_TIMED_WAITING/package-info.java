/**
 * 
 */
/**
 * @author 15753
 *
 */
package 第04章_共享模型之管程.s10_重新理解线程状态转换.c08_情况08_RUNNABLE_two_TIMED_WAITING;
/*

情况 9 RUNNABLE <--> BLOCKED
	t 线程用 synchronized(obj) 获取了对象锁时如果竞争失败，从 RUNNABLE --> BLOCKED
	
	持 obj 锁线程的同步代码块执行完毕，会唤醒该对象上所有 BLOCKED 的线程重新竞争，如果其中 t 线程竞争
	成功，从 BLOCKED --> RUNNABLE ，其它失败的线程仍然 BLOCKED

https://www.cnblogs.com/gosaint/p/9111189.html
	
综上所述，我们分别介绍了不同种线程的不同状态下对于中断请求的反应。
NEW和TERMINATED对于中断操作几乎是屏蔽的，RUNNABLE和BLOCKED类似，
对于中断操作只是设置中断标志位并没有强制终止线程，对于线程的终止权利依然在程序手中。
WAITING/TIMED_WAITING状态下的线程对于中断操作是敏感的，他们会抛出异常并清空中断标志位。
*/