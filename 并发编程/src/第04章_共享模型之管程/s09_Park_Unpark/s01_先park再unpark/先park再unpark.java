package ��04��_����ģ��֮�ܳ�.s09_Park_Unpark.s01_��park��unpark;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

import utils.Utils;

public class ��park��unpark {
/*	2020��03��23��  - 21:41:53.188 - t1 - start...
	2020��03��23��  - 21:41:54.245 - t1 - park...
	2020��03��23��  - 21:41:55.186 - main - unpark...
	2020��03��23��  - 21:41:55.186 - t1 - resume...*/
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
