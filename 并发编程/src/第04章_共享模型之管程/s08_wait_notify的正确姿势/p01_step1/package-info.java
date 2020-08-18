/**
 * 
 */
/**
 * @author 15753
 *
 */
package 第04章_共享模型之管程.s08_wait_notify的正确姿势.p01_step1;
/*

static final Object room = new Object();
static boolean hasCigarette = false;
static boolean hasTakeout = false;



*/
/*
 * 不好，原因如下：
	1.其它干活的线程，都要一直阻塞，效率太低
	2.小南线程必须睡足 2s 后才能醒来，就算烟提前送到，也无法立刻醒来
	3.加了 synchronized (room) 后，就好比小南在里面反锁了门睡觉，
	     烟根本没法送进门，main 没加synchronized 就好像 main 线程是翻窗户进来的
	5.解决方法，使用 wait - notify 机制
	
	---------------------------------
	开始之前先看看：
sleep(long n) 和 wait(long n) 的区别：
	1)sleep 是 Thread 方法，而 wait 是 Object 的方法
	2)sleep 不需要强制和 synchronized 配合使用， 但 wait 需要和 synchronized 一起用 
    3)sleep 在睡眠的同时，不会释放对象锁的，但 wait 在等待的时候会释放对象锁 
    4)它们状态 TIMED_WAITING
 */