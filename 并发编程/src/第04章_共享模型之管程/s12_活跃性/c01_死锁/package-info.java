/**
 * 
 */
/**
 * @author 15753
 *
 */
package 第04章_共享模型之管程.s12_活跃性.c01_死锁;

/*
结果
12:22:06.962 [t2] c.TestDeadLock - lock B
12:22:06.962 [t1] c.TestDeadLock - lock A


避免死锁要注意加锁顺序
另外如果由于某个线程进入了死循环，导致其它线程一直等待，对于这种情况 linux 下可以通过 top 先定位到
CPU 占用高的 Java 进程，再利用 top -Hp 进程id 来定位是哪个线程，最后再用 jstack 排查
*/