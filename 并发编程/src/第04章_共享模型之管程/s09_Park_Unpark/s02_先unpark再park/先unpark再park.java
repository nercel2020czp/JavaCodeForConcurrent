package 第04章_共享模型之管程.s09_Park_Unpark.s02_先unpark再park;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

import utils.Utils;

public class 先unpark再park {
	
	public static void main(String[] args) {
		Thread t1 = new Thread(() -> {
			Utils.log("start...");
			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Utils.log("park...");
			LockSupport.park();
			Utils.log("resume...");
		}, "t1");
		t1.start();
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Utils.log("unpark...");
		LockSupport.unpark(t1);
	}

}
