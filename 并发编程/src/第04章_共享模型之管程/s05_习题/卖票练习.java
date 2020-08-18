package ��04��_����ģ��֮�ܳ�.s05_ϰ��;
//������������Ƿ�����̰߳�ȫ���⣬�����Ը���

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

public class ��Ʊ��ϰ {
	public static void main(String[] args) {
		TicketWindow ticketWindow = new TicketWindow(2000);
		List<Thread> list = new ArrayList<>();
		// �����洢���ȥ������Ʊ
		//����߳����ٽ�����ִ�У����ڴ����ִ�����в�ͬ�����½���޷�Ԥ�⣬��֮Ϊ�����˾�̬����
		List<Integer> sellCount = new Vector<>();
		for (int i = 0; i < 2000; i++) {
			Thread t = new Thread(() -> {
				// ��������ľ�̬����
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
		// ���ȥ��Ʊ���
		Utils.log("selled count:" + sellCount.stream().mapToInt(c -> c).sum());
		// ʣ��Ʊ��
		Utils.log("remainder count:" + ticketWindow.getCount());
	}

	// Random Ϊ�̰߳�ȫ
	static Random random = new Random();

	// ��� 1~5
	public static int randomAmount() {
		return random.nextInt(5) + 1;
	}
}
