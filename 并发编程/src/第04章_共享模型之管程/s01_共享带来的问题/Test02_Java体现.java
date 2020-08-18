package 第04章_共享模型之管程.s01_共享带来的问题;

import utils.Utils;

public class Test02_Java体现 {
	static int counter = 0;

	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(() -> {
			for (int i = 0; i < 5000; i++) {
				counter++;
			}
		}, "t1");
		Thread t2 = new Thread(() -> {
			for (int i = 0; i < 5000; i++) {
				counter--;
			}
		}, "t2");
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		Utils.log("" + counter);
	}
}
