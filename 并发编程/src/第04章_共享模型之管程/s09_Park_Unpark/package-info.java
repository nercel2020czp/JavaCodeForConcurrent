/**
 * 
 */
/**
 * @author 15753
 *
 */
package 第04章_共享模型之管程.s09_Park_Unpark;
/*
基本使用
	它们是 LockSupport 类中的方法
		// 暂停当前线程
		LockSupport.park();
		// 恢复某个线程的运行
		LockSupport.unpark(暂停线程对象)
		
特点
	1.与 Object 的 wait & notify 相比wait，notify 和 notifyAll 必须配合 Object Monitor 一起使用，而 park，unpark 不必
	2.park & unpark 是以线程为单位来【阻塞】和【唤醒】线程，而 notify 只能随机唤醒一个等待线程，notifyAll是唤醒所有等待线程，就不那么【精确】
	3.park & unpark 可以先 unpark，而 wait & notify 不能先 notify
		
		
		

*/