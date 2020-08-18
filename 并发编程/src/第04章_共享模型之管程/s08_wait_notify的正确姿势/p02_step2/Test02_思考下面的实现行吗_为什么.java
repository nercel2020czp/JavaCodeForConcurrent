package 第04章_共享模型之管程.s08_wait_notify的正确姿势.p02_step2;

import java.util.concurrent.TimeUnit;

import utils.Utils;

public class Test02_思考下面的实现行吗_为什么 {
	
/*	解决了其它干活的线程阻塞的问题
	但如果有其它线程也在等待条件呢？*/
	
	static final Object room = new Object();
	static boolean hasCigarette = false;
	static boolean hasTakeout = false;
	public static void main(String[] args) {
		
		new Thread(() -> {
			synchronized (room) {
				Utils.log("有烟没？ " + hasCigarette);
				if (!hasCigarette) {
					Utils.log("没烟，先歇会！");
					try {
						room.wait(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				Utils.log("有烟没？ " + hasCigarette);
				if (hasCigarette) {
					Utils.log("可以开始干活了");
				}
			}
		}, "小南").start();
		
		for (int i = 0; i < 5; i++) {
			new Thread(() -> {
				synchronized (room) {
					Utils.log("可以开始干活了");
				}
			}, "其它人").start();
		}
		
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		new Thread(() -> {
			synchronized (room) {
				hasCigarette = true;
				Utils.log("烟到了噢！");
				room.notify();
			}
		}, "送烟的").start();
		
	}
}
