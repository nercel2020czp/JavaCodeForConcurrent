package 第04章_共享模型之管程.s08_wait_notify的正确姿势.p05_step5_虚假唤醒的解决2;

import java.util.concurrent.TimeUnit;

import utils.Utils;

public class 虚假唤醒的解决2 {
	static final Object room = new Object();
	static boolean hasCigarette = false;
	static boolean hasTakeout = false;
	public static void main(String[] args) {
		
		new Thread(() -> {
			synchronized (room) {
				Utils.log("有烟没？ " + hasCigarette);
				while (!hasCigarette) {
					Utils.log("没烟，先歇会！");
					try {
						room.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				Utils.log("有烟没？ " + hasCigarette);
				if (hasCigarette) {
					Utils.log("可以开始干活了");
				}else {
					Utils.log("干不成活了");
				}
			}
		}, "小南").start();
		
		new Thread(() -> {
			synchronized (room) {
				Utils.log("外卖到没？ " + hasTakeout);
				while (!hasTakeout) {
					Utils.log("外卖还没到，先歇会！");
					try {
						room.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				Utils.log("外卖到没？ " + hasTakeout);
				if (hasTakeout) {
					Utils.log("可以开始干活了");
				}else {
					Utils.log("干不成活了");
				}
			}
		}, "小女").start();
		
		
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		new Thread(() -> {
			synchronized (room) {
				hasTakeout = true;
				Utils.log("外卖到了噢！");
				room.notifyAll();
			}
		}, "送外卖的").start();
		
	}
}
