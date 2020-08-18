/**
 * 
 */
/**
 * @author 15753
 *
 */
package 第04章_共享模型之管程.s08_wait_notify的正确姿势;
/*

开始之前先看看
	sleep(long n) 和 wait(long n) 的区别
		1) sleep 是 Thread 方法，而 wait 是 Object 的方法 
		2) sleep 不需要强制和 synchronized 配合使用，但 wait 需要和 synchronized 一起用 
		3) sleep 在睡眠的同时，不会释放对象锁的，但 wait 在等待的时候会释放对象锁 
		4) 它们状态 TIMED_WAITING

*/