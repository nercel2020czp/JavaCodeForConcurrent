package p03_ͬ��ģʽ֮˳�����.s1_�̶�����˳��.c02_Park_Unpark_��;

import java.util.concurrent.locks.LockSupport;

public class Test01_Park_Unpark_�� {
	public static void main(String[] args) {
		Thread t1 = new Thread(() -> {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
			// ��û�С���ɡ�ʱ����ǰ�߳���ͣ���У��С���ɡ�ʱ���õ��������ɡ�����ǰ�ָ̻߳�����
			LockSupport.park();
			System.out.println("1");
		});
		Thread t2 = new Thread(() -> {
			System.out.println("2");
			// ���߳� t1 ���š���ɡ�������������� unpark ֻ�ᷢ��һ������ɡ���
			LockSupport.unpark(t1);
		});
		t1.start();
		t2.start();
	}
}
