package p06_��ֹģʽ֮���׶���ֹģʽ.s02_���׶���ֹģʽ.s01_����_isInterrupted;
//interrupt ���Դ������ִ�е��̣߳���������߳����� sleep��wait��������������

import utils.Utils;

class TPTInterrupt {
	private Thread thread;
	public void start() {
		thread = new Thread(() -> {
			while (true) {
				Thread current = Thread.currentThread();
				System.out.println(current == thread);//true
				if (current.isInterrupted()) {
					Utils.log("�������");
					break;
				}
				try {
					Thread.sleep(1000);
					Utils.log("���������");
				} catch (InterruptedException e) {
					e.printStackTrace();
					//�������ô�ϱ��
					//https://blog.csdn.net/Justin_bibo/article/details/107730316
					current.interrupt();
				}
				// ִ�м�ز���
			}
		}, "����߳�");
		thread.start();
	}

	public void stop() {
		thread.interrupt();
	}
}


public class Test01_����isInterrupted {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		TPTInterrupt t = new TPTInterrupt();
		t.start();
		Thread.sleep(3500);
		Utils.log("���߳̿�ʼ������߳�");
		t.stop();
//		Thread.sleep(10000);
//		Utils.log("���̴߳�����߳����");
	}

}
