package ��04��_����ģ��֮�ܳ�.s12_��Ծ��.c02_��ѧ�ҾͲ�����;

import utils.Utils;

/*����λ��ѧ�ң�Χ����Բ���ԡ�
	1.����ֻ�������£�˼���ͳԷ���˼��һ��Կڷ������극�����˼����
	2.�Է�ʱҪ���������ӳԣ����Ϲ��� 5 �����ӣ�ÿλ��ѧ�������ֱ߸���һ�����ӡ�
	3.������ӱ���ߵ������ţ��Լ��͵õȴ�*/
class Chopstick {
	String name;

	public Chopstick(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "����{" + name + '}';
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
			// ������ֿ���
			synchronized (left) {
				// ������ֿ���
				synchronized (right) {
					// �Է�
					eat();
				}
				// �������ֿ���
			}
			// �������ֿ���
		}
	}
}
public class Test01_��ѧ�ҾͲ�����_������ʾ {
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
		new Philosopher("�����׵�", c5, c1).start();//����������ʾ
	}
}
