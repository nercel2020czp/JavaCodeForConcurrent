package p06_��ֹģʽ֮���׶���ֹģʽ.s02_���׶���ֹģʽ.s02_����volatile���ε�ֹͣ���;

import utils.Utils;

//ֹͣ����� volatile ��Ϊ�˱�֤�ñ����ڶ���߳�֮��Ŀɼ���
//���ǵ������У������̰߳����޸�Ϊ true �� t1 �߳̿ɼ�
class TPTVolatile {
	private Thread thread;
	private volatile boolean stop = false;

	public void start() {
		thread = new Thread(() -> {
//			Thread current = Thread.currentThread();
			while (true) {
				if (stop) {
					Utils.log("�������");
					break;
				}
				try {
					Thread.sleep(1000);
					Utils.log("���������");
				} catch (InterruptedException e) {
				}
				// ִ�м�ز���
			}
		}, "����߳�");
		thread.start();
	}
	public void stop() {
		stop = true;
		thread.interrupt();
	}
}


public class Test02_����ֹͣ��� {
	public static void main(String[] args) throws InterruptedException {
		TPTVolatile t = new TPTVolatile();
		t.start();
		Thread.sleep(3500);
		Utils.log("stop");
		t.stop();
	}
}
