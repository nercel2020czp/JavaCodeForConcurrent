package ��04��_����ģ��֮�ܳ�.s13_ReentrantLock.c03_����ʱ.c03_ʹ��tryLock�����ѧ�ҾͲ�����;

import java.util.concurrent.locks.ReentrantLock;
import utils.Utils;

class Chopstick extends ReentrantLock {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String name;
	public Chopstick(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "����{" + name + '}';
	}
}
////////////////////////////////
class Philosopher extends Thread {
	Chopstick left;
	Chopstick right;

	public Philosopher(String name, Chopstick left, Chopstick right) {
		super(name);
		this.left = left;
		this.right = right;
	}
	@Override
	public void run() {
		while (true) {
			// ���Ի�����ֿ���
			if (left.tryLock()) {
				try {
					// ���Ի�����ֿ���
					if (right.tryLock()) {
						try {
							eat();
						} finally {
							right.unlock();
						}
					}
				} finally {
					left.unlock();
				}
			}
		}
	}

	private void eat() {
		Utils.log("eating...");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

public class Test01_ʹ��tryLock�����ѧ�ҾͲ����� {
	public static void main(String[] args) {
		Chopstick c1 = new Chopstick("1");
		Chopstick c2 = new Chopstick("2");
		Chopstick c3 = new Chopstick("3");
		Chopstick c4 = new Chopstick("4");
		Chopstick c5 = new Chopstick("5");
		new Philosopher("�ո�����", c1, c2).start();
		new Philosopher("����ͼ", c2, c3).start();
		new Philosopher("����ʿ���", c3, c4).start();
		new Philosopher("����������", c4, c5).start();
		new Philosopher("�����׵�", c5, c1).start();
	}
}
