package p03_ͬ��ģʽ֮˳�����.s1_�̶�����˳��.c01_wait_notify��;

public class Test01_wait_notify_�� {
	// ����ͬ���Ķ���
	static Object obj = new Object();
	// t2 ���б�ǣ� ���� t2 �Ƿ�ִ�й�
	static boolean t2runed = false;
	
	public static void main(String[] args) {
		Thread t1 = new Thread(() -> {
			synchronized (obj) {
				// ��� t2 û��ִ�й�
				while (!t2runed) {
					try {
						// t1 �ȵ�һ��
						obj.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
			System.out.println(1);
		});
		Thread t2 = new Thread(() -> {
			System.out.println(2);
			synchronized (obj) {
				// �޸����б��
				t2runed = true;
				// ֪ͨ obj �ϵȴ����̣߳������ж���������Ҫ�� notifyAll��
				obj.notifyAll();
			}
		});
		t1.start();
		t2.start();
	}
}
