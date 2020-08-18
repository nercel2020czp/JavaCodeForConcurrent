package 第04章_共享模型之管程.s02_synchronized解决方案;

import utils.Utils;

//把需要保护的共享变量放入一个类

class Room {
	int value = 0;

	public void increment() {
		synchronized (this) {
			value++;
		}
	}

	public void decrement() {
		synchronized (this) {
			value--;
		}
	}

	public int get() {
		synchronized (this) {
			return value;
		}
	}
}

public class Test04_面向对象改进 {
	public static void main(String[] args) throws InterruptedException {
		Room room = new Room();
		Thread t1 = new Thread(() -> {
			for (int j = 0; j < 100; j++) {
				Utils.log(""+j);
				room.increment();
			}
		}, "t1");
		Thread t2 = new Thread(() -> {
			for (int j = 0; j < 100; j++) {
				Utils.log(""+j);
				room.decrement();
			}
		}, "t2");
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		Utils.log("count: " + room.get());
	}
}
