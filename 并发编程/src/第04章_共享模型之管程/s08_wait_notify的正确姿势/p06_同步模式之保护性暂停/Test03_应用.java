package 第04章_共享模型之管程.s08_wait_notify的正确姿势.p06_同步模式之保护性暂停;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import utils.Utils;

/*
一个线程等待另一个线程的执行结果
*/
public class Test03_应用 {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		Thread.currentThread().setName("get");
		GuardedObject guardedObject = new GuardedObject();
		new Thread(() -> {
			// 子线程执行下载
			try {
				Utils.log("downloading...");
				TimeUnit.SECONDS.sleep(4);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			List<String> response = new LinkedList<>();
			response.add("阿森纳");
			response.add("热刺");
			response.add("曼城");
			response.add("利物浦");
			Utils.log("download complete...");
			guardedObject.complete(response);
		}, "complete").start();
		Utils.log("waiting...");
		// 主线程阻塞等待
//		Thread.currentThread().setName("get");
		Object response = guardedObject.get();
		Utils.log("get response:  " + ((List<String>) response).size() + " lines");
	}
}
