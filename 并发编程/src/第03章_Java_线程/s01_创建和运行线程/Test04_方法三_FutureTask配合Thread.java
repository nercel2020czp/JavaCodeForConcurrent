package 第03章_Java_线程.s01_创建和运行线程;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

import utils.Utils;

//FutureTask 能够接收 Callable 类型的参数，用来处理有返回结果的情况
public class Test04_方法三_FutureTask配合Thread {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// 创建任务对象
		FutureTask<Integer> task3 = new FutureTask<>(() -> {
			Utils.log("hello");
			return 100;
		});
		// 参数1 是任务对象; 参数2 是线程名字，推荐
		new Thread(task3, "t3").start();
		// 主线程阻塞，同步等待 task 执行完毕的结果
		Integer result = task3.get();
		Utils.log("结果是: " + result);
	}
}
