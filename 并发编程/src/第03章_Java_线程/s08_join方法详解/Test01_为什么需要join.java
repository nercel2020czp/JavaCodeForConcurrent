package ��03��_Java_�߳�.s08_join�������;
/*����
	��Ϊ���̺߳��߳� t1 �ǲ���ִ�еģ�t1 �߳���Ҫ 1 ��֮�������� r=10
	�����߳�һ��ʼ��Ҫ��ӡ r �Ľ��������ֻ�ܴ�ӡ�� r=0
	
�������
	�� sleep �в��У�Ϊʲô��
		��̫�ã����У���Ϊ�㲻֪�����߳�Ҫִ�ж೤ʱ�䣬��ô���߳�Ҫ�ȶ�ã�
	�� join������ t1.start() ֮�󼴿�

join()
	�ȴ��߳����н���
join(long n)
	�ȴ��߳����н���,���ȴ� n����
*/
import utils.Utils;

public class Test01_Ϊʲô��Ҫjoin {
	static int r = 0;

	public static void main(String[] args) throws InterruptedException {
		test1();
	}

	private static void test1() throws InterruptedException {
		Utils.log("��ʼ");
		Thread t1 = new Thread(() -> {
			Utils.log("��ʼ");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Utils.log("����");
			r = 10;
		}, "t1");
		t1.start();
/*		join()
			�ȴ��߳����н���
		join(long n)
			�ȴ��߳����н���,���ȴ� n����*/
		t1.join();
//		Thread.sleep(2000);
		Utils.log("���Ϊ:" + r);
		Utils.log("����");
	}
}
