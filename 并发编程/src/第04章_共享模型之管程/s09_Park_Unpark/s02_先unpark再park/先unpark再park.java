package ��04��_����ģ��֮�ܳ�.s09_Park_Unpark.s02_��unpark��park;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

import utils.Utils;

public class ��unpark��park {
	
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
