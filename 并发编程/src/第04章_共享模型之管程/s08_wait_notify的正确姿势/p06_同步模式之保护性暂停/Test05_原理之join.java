package ��04��_����ģ��֮�ܳ�.s08_wait_notify����ȷ����.p06_ͬ��ģʽ֮��������ͣ;
/*join ԭ��
�ǵ�������ѯ����߳� alive ״̬

t1.join();

//�ȼ�������Ĵ���:

	synchronized (t1) {
		// �������߳̽��� t1 �� waitSet �ȴ�, ֱ�� t1 ���н���
		while (t1.isAlive()) {
			t1.wait(0);
		}
	}

ע��
join ���ֵ��ǡ���������ͣ��ģʽ����ο�֮

*/
public class Test05_ԭ��֮join {

}
