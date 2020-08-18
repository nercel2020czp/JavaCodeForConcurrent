/**
 * 
 */
/**
 * @author 15753
 *
 */
package 第03章_Java_线程.s09_interrupt方法详解.s01_打断sleep_wait_join的线程;
/*
打断 sleep，wait，join 的线程
	这几个方法都会让线程进入阻塞状态
	打断 sleep 的线程, 会清空打断状态，以 sleep 为例

输出:
	java.lang.InterruptedException: sleep interrupted
	at java.lang.Thread.sleep(Native Method)
	at java.lang.Thread.sleep(Thread.java:340)
	at java.util.concurrent.TimeUnit.sleep(TimeUnit.java:386)
	at cn.itcast.n2.util.Sleeper.sleep(Sleeper.java:8)
	at cn.itcast.n4.TestInterrupt.lambda$test1$3(TestInterrupt.java:59)
	at java.lang.Thread.run(Thread.java:745)
	21:18:10.374 [main] c.TestInterrupt - 打断状态: false

*/