package ��03��_Java_�߳�.s09_interrupt�������.s02_����������е��߳�;

/*
sleep
	1. ���� sleep ���õ�ǰ�̴߳� Running ���� Timed Waiting ״̬��������
	2. �����߳̿���ʹ�� interrupt �����������˯�ߵ��̣߳�
	       ��ʱ sleep �������׳� InterruptedException
	3. ˯�߽�������߳�δ�ػ����̵õ�ִ��
	4. ������ TimeUnit �� sleep ���� Thread �� sleep ����ø��õĿɶ���

*/
import java.util.concurrent.TimeUnit;
import utils.Utils;

//����������е��߳�, ������մ��״̬
public class Test02_��������߳� {
	private static void test2() throws InterruptedException {
		Thread t2 = new Thread(() -> {
			Utils.log("����");
			Thread current = Thread.currentThread();
			/*			��Core Java��������һ�仰��
			"û���κ����Է��������Ҫ��һ�����жϵĳ���Ӧ����ֹ��
			�ж�һ���߳�ֻ��Ϊ��������̵߳�ע�⣬���ж��߳̿��Ծ������Ӧ���ж� "��
*/			while (true) {
//				Utils.log("��������....");
				boolean interrupted = current.isInterrupted();
				if (interrupted) {
					//����������е��߳�, ������մ��״̬
					Utils.log(" ���״̬: " + interrupted);
					//2020��03��19��  - 08:14:34.566 - t2 -  ���״̬: true
					break;
				}
			}
			Utils.log("��ʼ˯��");
			Utils.log("��ʼ˯��");
			Utils.log("��ʼ˯��");
			Utils.log("��ʼ˯��");
			Utils.log("��ʼ˯��");
			Utils.log("��ʼ˯��");
//			���ʱ������жϱ�־λ�Ѿ���true�ˣ��Ͳ����ڱ�������
//			try {
//				TimeUnit.SECONDS.sleep(2);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			Utils.log("��������");
			Utils.log("��������");
			Utils.log("��������");
			Utils.log("��������");
			Utils.log("��������");
			Utils.log("��������");
			Utils.log("��������");
			Utils.log("��������");
		}, "t2");
		t2.start();
		Utils.log("��ʼ˯��");
		TimeUnit.SECONDS.sleep(2);
		Utils.log("����˯��");
		Utils.log("��ʼ��������߳�");
		t2.interrupt();
		Utils.log("������������߳�");
		Utils.log("��������˺�����˯��");
		Utils.log("Ҫ������");
	}
	
	public static void main(String[] args) throws InterruptedException {

		test2();
	}

}
