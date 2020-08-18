package 第03章_Java_线程.s01_创建和运行线程;
/*// 创建线程对象
Thread t = new Thread() {
	public void run() {
		// 要执行的任务
	}
};
// 启动线程
t.start();*/
import utils.Utils;

public class Test01_方法一_直接使用Thread {
	public static void main(String[] args) {
		// 构造方法的参数是给线程指定名字，推荐
		Thread t1 = new Thread("t1") {
			@Override
			// run 方法内实现了要执行的任务
			public void run() {
				Utils.log("hello");
			}
		};
		t1.start();
	}
}
