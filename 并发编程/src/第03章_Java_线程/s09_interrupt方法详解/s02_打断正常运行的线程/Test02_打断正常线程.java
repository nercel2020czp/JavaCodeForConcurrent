package 第03章_Java_线程.s09_interrupt方法详解.s02_打断正常运行的线程;

/*
sleep
	1. 调用 sleep 会让当前线程从 Running 进入 Timed Waiting 状态（阻塞）
	2. 其它线程可以使用 interrupt 方法打断正在睡眠的线程，
	       这时 sleep 方法会抛出 InterruptedException
	3. 睡眠结束后的线程未必会立刻得到执行
	4. 建议用 TimeUnit 的 sleep 代替 Thread 的 sleep 来获得更好的可读性

*/
import java.util.concurrent.TimeUnit;
import utils.Utils;

//打断正常运行的线程, 不会清空打断状态
public class Test02_打断正常线程 {
	private static void test2() throws InterruptedException {
		Thread t2 = new Thread(() -> {
			Utils.log("启动");
			Thread current = Thread.currentThread();
			/*			在Core Java中有这样一句话：
			"没有任何语言方面的需求要求一个被中断的程序应该终止。
			中断一个线程只是为了引起该线程的注意，被中断线程可以决定如何应对中断 "。
*/			while (true) {
//				Utils.log("正在做事....");
				boolean interrupted = current.isInterrupted();
				if (interrupted) {
					//打断正常运行的线程, 不会清空打断状态
					Utils.log(" 打断状态: " + interrupted);
					//2020年03月19日  - 08:14:34.566 - t2 -  打断状态: true
					break;
				}
			}
			Utils.log("开始睡觉");
			Utils.log("开始睡觉");
			Utils.log("开始睡觉");
			Utils.log("开始睡觉");
			Utils.log("开始睡觉");
			Utils.log("开始睡觉");
//			这个时候，你的中断标志位已经是true了，就不能在被阻塞了
//			try {
//				TimeUnit.SECONDS.sleep(2);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			Utils.log("结束运行");
			Utils.log("结束运行");
			Utils.log("结束运行");
			Utils.log("结束运行");
			Utils.log("结束运行");
			Utils.log("结束运行");
			Utils.log("结束运行");
			Utils.log("结束运行");
		}, "t2");
		t2.start();
		Utils.log("开始睡觉");
		TimeUnit.SECONDS.sleep(2);
		Utils.log("结束睡觉");
		Utils.log("开始打断其他线程");
		t2.interrupt();
		Utils.log("结束打断其他线程");
		Utils.log("打断其他人后，我再睡会");
		Utils.log("要结束啦");
	}
	
	public static void main(String[] args) throws InterruptedException {

		test2();
	}

}
