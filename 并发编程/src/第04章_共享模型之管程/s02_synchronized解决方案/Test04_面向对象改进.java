package ��04��_����ģ��֮�ܳ�.s02_synchronized�������;

import utils.Utils;

//����Ҫ�����Ĺ����������һ����

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

public class Test04_�������Ľ� {
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
