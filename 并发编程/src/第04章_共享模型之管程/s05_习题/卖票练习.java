package 第04章_共享模型之管程.s05_习题;
//测试下面代码是否存在线程安全问题，并尝试改正

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Vector;

import utils.Utils;

class TicketWindow {
	private int count;

	public TicketWindow(int count) {
		this.count = count;
	}

	public int getCount() {
		return count;
	}

	public int sell(int amount) {
		if (this.count >= amount) {
			this.count -= amount;
			return amount;
		} else {
			return 0;
		}
	}
}

public class 卖票练习 {
	public static void main(String[] args) {
		TicketWindow ticketWindow = new TicketWindow(2000);
		List<Thread> list = new ArrayList<>();
		// 用来存储买出去多少张票
		//多个线程在临界区内执行，由于代码的执行序列不同而导致结果无法预测，称之为发生了竞态条件
		List<Integer> sellCount = new Vector<>();
		for (int i = 0; i < 2000; i++) {
			Thread t = new Thread(() -> {
				// 分析这里的竞态条件
				int count = ticketWindow.sell(randomAmount());
				sellCount.add(count);
			});
			list.add(t);
			t.start();
		}
		list.forEach((t) -> {
			try {
				t.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		// 买出去的票求和
		Utils.log("selled count:" + sellCount.stream().mapToInt(c -> c).sum());
		// 剩余票数
		Utils.log("remainder count:" + ticketWindow.getCount());
	}

	// Random 为线程安全
	static Random random = new Random();

	// 随机 1~5
	public static int randomAmount() {
		return random.nextInt(5) + 1;
	}
}
