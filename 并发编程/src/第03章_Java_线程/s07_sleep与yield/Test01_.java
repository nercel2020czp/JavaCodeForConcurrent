package ��03��_Java_�߳�.s07_sleep��yield;
/*sleep
	1. ���� sleep ���õ�ǰ�̴߳� Running ���� Timed Waiting ״̬��������
	2. �����߳̿���ʹ�� interrupt �����������˯�ߵ��̣߳���ʱ sleep �������׳� 
	   InterruptedException
	3. ˯�߽�������߳�δ�ػ����̵õ�ִ��
	4. ������ TimeUnit �� sleep ���� Thread �� sleep ����ø��õĿɶ���
yield
	1. ���� yield ���õ�ǰ�̴߳� Running ���� Runnable ����״̬��Ȼ�����ִ�������߳�
	2. �����ʵ�������ڲ���ϵͳ�����������
---------------------------------------------
�߳����ȼ�
�߳����ȼ�����ʾ��hint�����������ȵ��ȸ��̣߳�����������һ����ʾ�����������Ժ�����
��� cpu �Ƚ�æ����ô���ȼ��ߵ��̻߳��ø����ʱ��Ƭ���� cpu ��ʱ�����ȼ�����û����*/
public class Test01_ {
	public static void main(String[] args) {
		Runnable task1 = () -> {
			int count = 0;
			for (;;) {
				System.out.println("---->1 " + count++);
			}
		};
		Runnable task2 = () -> {
			int count = 0;
			for (;;) {
				// Thread.yield();
				System.out.println(" ---->2 " + count++);
			}
		};
		Thread t1 = new Thread(task1, "t1");
		Thread t2 = new Thread(task2, "t2");
		t1.setPriority(Thread.MIN_PRIORITY);
		t2.setPriority(Thread.MAX_PRIORITY);
		t1.start();
		t2.start();
	}
}
