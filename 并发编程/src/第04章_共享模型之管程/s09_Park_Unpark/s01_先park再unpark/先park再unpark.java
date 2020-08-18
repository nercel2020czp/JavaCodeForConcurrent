package 第04章_共享模型之管程.s09_Park_Unpark.s01_先park再unpark;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

import utils.Utils;

public class 先park再unpark {
/*	2020年03月23日  - 21:41:53.188 - t1 - start...
	2020年03月23日  - 21:41:54.245 - t1 - park...
	2020年03月23日  - 21:41:55.186 - main - unpark...
	2020年03月23日  - 21:41:55.186 - t1 - resume...*/
	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(() -> {
			Utils.log("start...");
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Utils.log("park...");
			LockSupport.park();
			Utils.log("resume...");
		}, "t1");
		t1.start();
		TimeUnit.SECONDS.sleep(5);
		Utils.log("unpark...");
		LockSupport.unpark(t1);
	}

}
