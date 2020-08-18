/**
 * 
 */
/**
 * @author 15753
 *
 */
package 第04章_共享模型之管程.s13_ReentrantLock.c02_可打断.c02_不可中断模式_interrupt;
/*

注意如果是不可中断模式，那么即使使用了 interrupt 也不会让等待中断

输出
18:06:56.261 [main] c.TestInterrupt - 获得了锁
18:06:56.265 [t1] c.TestInterrupt - 启动...
18:06:57.266 [main] c.TestInterrupt - 执行打断 // 这时 t1 并没有被真正打断, 而是仍继续等待锁
18:06:58.267 [main] c.TestInterrupt - 释放了锁
18:06:58.267 [t1] c.TestInterrupt - 获得了锁

*/