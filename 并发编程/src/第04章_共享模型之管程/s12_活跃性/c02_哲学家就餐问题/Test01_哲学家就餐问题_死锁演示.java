package 第04章_共享模型之管程.s12_活跃性.c02_哲学家就餐问题;

import utils.Utils;

/*有五位哲学家，围坐在圆桌旁。
	1.他们只做两件事，思考和吃饭，思考一会吃口饭，吃完饭后接着思考。
	2.吃饭时要用两根筷子吃，桌上共有 5 根筷子，每位哲学家左右手边各有一根筷子。
	3.如果筷子被身边的人拿着，自己就得等待*/
class Chopstick {
	String name;

	public Chopstick(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "筷子{" + name + '}';
	}
}

class Philosopher extends Thread {
	Chopstick left;
	Chopstick right;

	public Philosopher(String name, Chopstick left, Chopstick right) {
		super(name);
		this.left = left;
		this.right = right;
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

	@Override
	public void run() {
		while (true) {
			// 获得左手筷子
			synchronized (left) {
				// 获得右手筷子
				synchronized (right) {
					// 吃饭
					eat();
				}
				// 放下右手筷子
			}
			// 放下左手筷子
		}
	}
}
public class Test01_哲学家就餐问题_死锁演示 {
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
		new Philosopher("阿基米德", c5, c1).start();//死锁现象演示
	}
}
