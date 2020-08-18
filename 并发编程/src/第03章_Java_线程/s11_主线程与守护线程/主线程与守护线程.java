package 第03章_Java_线程.s11_主线程与守护线程;
/*

默认情况下，Java 进程需要等待所有线程都运行结束，才会结束。有一种特殊的线程叫做守护线程，
只要其它非守护线程运行结束了，即使守护线程的代码没有执行完，也会强制结束。

注意:
	1.垃圾回收器线程就是一种守护线程
	2.Tomcat 中的 Acceptor 和 Poller 线程都是守护线程，
	     所以 Tomcat 接收到 shutdown 命令后，不会等待它们处理完当前请求

*/
import java.util.concurrent.TimeUnit;

import utils.Utils;

public class 主线程与守护线程 {

	public static void main(String[] args) throws InterruptedException {

		Utils.log("开始运行...");
		Thread t1 = new Thread(() -> {
			Utils.log("开始运行...");
			try {
				TimeUnit.SECONDS.sleep(4);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Utils.log("运行结束...");
		}, "daemon");
		// 设置该线程为守护线程
		t1.setDaemon(true);
		t1.start();
		TimeUnit.SECONDS.sleep(2);
		Utils.log("运行结束...");
		
	}

}
