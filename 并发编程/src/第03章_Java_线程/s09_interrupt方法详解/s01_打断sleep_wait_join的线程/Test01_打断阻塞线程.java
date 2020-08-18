package ��03��_Java_�߳�.s09_interrupt�������.s01_���sleep_wait_join���߳�;

import java.util.concurrent.TimeUnit;

import utils.Utils;

/*�⼸������sleep_wait_join�������߳̽�������״̬
��� sleep ���߳�, ����մ��״̬���� sleep Ϊ��
https://blog.csdn.net/Justin_bibo/article/details/107730316
	java.lang.InterruptedException: sleep interrupted
		at java.lang.Thread.sleep(Native Method)
		at java.lang.Thread.sleep(Thread.java:340)
		at java.util.concurrent.TimeUnit.sleep(TimeUnit.java:386)
		at cn.itcast.n2.util.Sleeper.sleep(Sleeper.java:8)
		at cn.itcast.n4.TestInterrupt.lambda$test1$3(TestInterrupt.java:59)
		at java.lang.Thread.run(Thread.java:745)
	21:18:10.374 [main] c.TestInterrupt - ���״̬: false
	
sleep
	1. ���� sleep ���õ�ǰ�̴߳� Running ���� Timed Waiting ״̬��������
	2. �����߳̿���ʹ�� interrupt �����������˯�ߵ��̣߳���ʱ sleep 
	       �������׳� InterruptedException
	3. ˯�߽�������߳�δ�ػ����̵õ�ִ��
	4. ������ TimeUnit �� sleep ���� Thread �� sleep ����ø��õĿɶ���

*/
public class Test01_��������߳� {
	public static void main(String[] args) {
		try {
			test1();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private static void test1() throws InterruptedException {
		Thread t1 = new Thread(() -> {
			try {
				Utils.log("��ʼ˯��");
				TimeUnit.SECONDS.sleep(5);//wait, join����մ��״̬
			} catch (InterruptedException e) {
				Utils.log("����˯��");
				e.printStackTrace();
			}
			Utils.log("����˯��!!!");
		}, "t1");
		t1.start();
		Utils.log("��ʼ˯��");
		TimeUnit.SECONDS.sleep(3);
		Utils.log("����˯��");
		Utils.log("��ʼ���t1");
		
/*		1 boolean isInterrupted();��ʾ�жϸ��߳��Ƿ����ж�λ��
		��������ж�λ�ã�����true,���򷵻�false;Ĭ������´��ڷ��ж�λ��
		����false;(Դ������)
*/		
		t1.interrupt();
		Utils.log("���t1����");
		Utils.log(" ���״̬: " + t1.isInterrupted());
		//����ʹ�ô�ϱ�����ж�����ֹ���Ǽ�������
		//2020��03��19��  - 08:08:50.263 - main -  ���״̬: false
	}
}
