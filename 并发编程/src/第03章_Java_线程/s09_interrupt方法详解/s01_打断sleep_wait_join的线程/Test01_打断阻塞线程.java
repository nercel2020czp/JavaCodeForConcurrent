package 第03章_Java_线程.s09_interrupt方法详解.s01_打断sleep_wait_join的线程;

import java.util.concurrent.TimeUnit;

import utils.Utils;

/*这几个方法sleep_wait_join都会让线程进入阻塞状态
打断 sleep 的线程, 会清空打断状态，以 sleep 为例
https://blog.csdn.net/Justin_bibo/article/details/107730316
	java.lang.InterruptedException: sleep interrupted
		at java.lang.Thread.sleep(Native Method)
		at java.lang.Thread.sleep(Thread.java:340)
		at java.util.concurrent.TimeUnit.sleep(TimeUnit.java:386)
		at cn.itcast.n2.util.Sleeper.sleep(Sleeper.java:8)
		at cn.itcast.n4.TestInterrupt.lambda$test1$3(TestInterrupt.java:59)
		at java.lang.Thread.run(Thread.java:745)
	21:18:10.374 [main] c.TestInterrupt - 打断状态: false
	
sleep
	1. 调用 sleep 会让当前线程从 Running 进入 Timed Waiting 状态（阻塞）
	2. 其它线程可以使用 interrupt 方法打断正在睡眠的线程，这时 sleep 
	       方法会抛出 InterruptedException
	3. 睡眠结束后的线程未必会立刻得到执行
	4. 建议用 TimeUnit 的 sleep 代替 Thread 的 sleep 来获得更好的可读性

*/
public class Test01_打断阻塞线程 {
	public static void main(String[] args) {
		try {
			test1();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private static void test1() throws InterruptedException {
		Thread t1 = new Thread(() -> {
			try {
				Utils.log("开始睡觉");
				TimeUnit.SECONDS.sleep(5);//wait, join会清空打断状态
			} catch (InterruptedException e) {
				Utils.log("结束睡觉");
				e.printStackTrace();
			}
			Utils.log("结束睡觉!!!");
		}, "t1");
		t1.start();
		Utils.log("开始睡觉");
		TimeUnit.SECONDS.sleep(3);
		Utils.log("结束睡觉");
		Utils.log("开始打断t1");
		
/*		1 boolean isInterrupted();表示判断该线程是否处于中断位；
		如果处于中断位置，返回true,否则返回false;默认情况下处于非中断位，
		返回false;(源码如下)
*/		
		t1.interrupt();
		Utils.log("打断t1结束");
		Utils.log(" 打断状态: " + t1.isInterrupted());
		//将来使用打断标记来判断是终止还是继续运行
		//2020年03月19日  - 08:08:50.263 - main -  打断状态: false
	}
}
