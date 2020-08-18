package 第03章_Java_线程.s01_创建和运行线程;

import utils.Utils;

/*
把【线程】和【任务】（要执行的代码）分开
	Thread 代表线程
	Runnable 可运行的任务（线程要执行的代码）
	
		Runnable runnable = new Runnable() {
			public void run() {
				// 要执行的任务
			}
		};
		// 创建线程对象
		Thread t = new Thread(runnable);
		// 启动线程
		t.start();
	
*/
public class Test02_方法二_使用Runnable配合Thread {
	public static void main(String[] args) {
		// 创建任务对象
		Runnable task2 = new Runnable() {
			@Override
			public void run() {
				Utils.log("hello");
			}
		};
		// 参数1 是任务对象; 参数2 是线程名字，推荐
		Thread t2 = new Thread(task2, "t2");
		t2.start();
	}
}
