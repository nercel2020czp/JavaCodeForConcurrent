package 第04章_共享模型之管程.s08_wait_notify的正确姿势.p01_step1;

import java.util.concurrent.TimeUnit;
import utils.Utils;

public class Test01_思考下面的解决方案好不好_为什么 {

	static final Object room = new Object();
	static boolean hasCigarette = false;
	static boolean hasTakeout = false;
	
	public static void main(String[] args) {
		new Thread(() -> {
			synchronized (room) {
				Utils.log("干了一个小时，有点累了");
				Utils.log("有烟没？ " +  hasCigarette);
				if (!hasCigarette) {
					//加了 synchronized (room) 后，就好比小南在里面反锁了门睡觉，
					Utils.log("没烟，先歇会！");
					try {
						TimeUnit.SECONDS.sleep(5);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				Utils.log("有烟没？" + hasCigarette);
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
			// 这里能不能加 synchronized (room)？
			//main 没加synchronized 就好像 main 线程是翻窗户进来的
//			synchronized (room) {
				hasCigarette = true;
				Utils.log("烟到了噢！");
//			}
		}, "送烟的").start();
		
	}
}
