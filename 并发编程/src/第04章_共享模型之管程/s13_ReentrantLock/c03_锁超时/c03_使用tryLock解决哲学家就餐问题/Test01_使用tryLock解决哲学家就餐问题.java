package 第04章_共享模型之管程.s13_ReentrantLock.c03_锁超时.c03_使用tryLock解决哲学家就餐问题;

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
		return "筷子{" + name + '}';
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
			// 尝试获得左手筷子
			if (left.tryLock()) {
				try {
					// 尝试获得右手筷子
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

public class Test01_使用tryLock解决哲学家就餐问题 {
	public static void main(String[] args) {
		Chopstick c1 = new Chopstick("1");
		Chopstick c2 = new Chopstick("2");
		Chopstick c3 = new Chopstick("3");
		Chopstick c4 = new Chopstick("4");
		Chopstick c5 = new Chopstick("5");
		new Philosopher("苏格拉底", c1, c2).start();
		new Philosopher("柏拉图", c2, c3).start();
		new Philosopher("亚里士多德", c3, c4).start();
		new Philosopher("赫拉克利特", c4, c5).start();
		new Philosopher("阿基米德", c5, c1).start();
	}
}
