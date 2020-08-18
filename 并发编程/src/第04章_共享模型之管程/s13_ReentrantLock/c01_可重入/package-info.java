/**
 * 
 */
/**
 * @author 15753
 *
 */
package 第04章_共享模型之管程.s13_ReentrantLock.c01_可重入;
/*
可重入是指同一个线程如果首次获得了这把锁，那么因为它是这把锁的拥有者，
因此有权利再次获取这把锁
如果是不可重入锁，那么第二次获得锁时，自己也会被锁挡住


输出
17:59:11.862 [main] c.TestReentrant - execute method1
17:59:11.865 [main] c.TestReentrant - execute method2
17:59:11.865 [main] c.TestReentrant - execute method3
*/