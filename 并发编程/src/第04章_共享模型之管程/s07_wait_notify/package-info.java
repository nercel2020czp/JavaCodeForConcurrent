/**
 * 
 */
/**
 * @author 15753
 *
 */
package 第04章_共享模型之管程.s07_wait_notify;

/*

4.7 wait notify

小故事 - 为什么需要 wait
	由于条件不满足，小南不能继续进行计算
	但小南如果一直占用着锁，其它人就得一直阻塞，效率太低
	
	于是老王单开了一间休息室（调用 wait 方法），让小南到休息室（WaitSet）等着去了，但这时锁释放开，
	其它人可以由老王随机安排进屋
	直到小M将烟送来，大叫一声 [ 你的烟到了 ] （调用 notify 方法）
	
	小南于是可以离开休息室，重新进入竞争锁的队列
	
* 原理之 wait / notify


API 介绍
	obj.wait() 让进入 object 监视器的线程到 waitSet 等待
	obj.notify() 在 object 上正在 waitSet 等待的线程中挑一个唤醒
	obj.notifyAll() 让 object 上正在 waitSet 等待的线程全部唤醒
	
它们都是线程之间进行协作的手段，都属于 Object 对象的方法。必须获得此对象的锁，才能调用这几个方法

	wait() 方法会释放对象的锁，进入 WaitSet 等待区，从而让其他线程就机会获取对象的锁。
	无限制等待，直到notify 为止
	
	wait(long n) 有时限的等待, 到 n 毫秒后结束等待，或是被 notify

*/