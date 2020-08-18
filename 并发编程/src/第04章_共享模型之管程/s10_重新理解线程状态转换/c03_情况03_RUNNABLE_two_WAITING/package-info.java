/**
 * 
 */
/**
 * @author 15753
 *
 */
package 第04章_共享模型之管程.s10_重新理解线程状态转换.c03_情况03_RUNNABLE_two_WAITING;
/*

情况 3 RUNNABLE <--> WAITING
	当前线程调用 t.join() 方法时，当前线程从 RUNNABLE --> WAITING
	注意是当前线程在t 线程对象的监视器上等待
	t 线程运行结束，或调用了当前线程的 interrupt() 时，当前线程从 WAITING --> RUNNABLE

*/