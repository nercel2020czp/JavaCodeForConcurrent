/**
 * 
 */
/**
 * @author 15753
 *
 */
package p03_同步模式之顺序控制.s2_交替输出.s1_wait_notify_版;

/*

API 介绍:
	obj.wait() 让进入 object 监视器的线程到 waitSet 等待
	obj.notify() 在 object 上正在 waitSet 等待的线程中挑一个唤醒
	obj.notifyAll() 让 object 上正在 waitSet 等待的线程全部唤醒
	
它们都是线程之间进行协作的手段，都属于 Object 对象的方法。必须获得此对象的锁，才能调用这几个方法



*/