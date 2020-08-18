/**
 * 
 */
/**
 * @author 15753
 *
 */
package 第04章_共享模型之管程.s13_ReentrantLock;
/*
相对于 synchronized 它具备如下特点
	可中断
	可以设置超时时间
	可以设置为公平锁
	支持多个条件变量

与 synchronized 一样，都支持可重入
	基本语法
	
	// 获取锁
reentrantLock.lock();
try {
	// 临界区
} finally {
	// 释放锁
	reentrantLock.unlock();
}
*/