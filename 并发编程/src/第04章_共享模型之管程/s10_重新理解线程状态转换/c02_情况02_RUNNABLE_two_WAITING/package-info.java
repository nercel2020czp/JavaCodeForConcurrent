/**
 * 
 */
/**
 * @author 15753
 *
 */
package ��04��_����ģ��֮�ܳ�.s10_��������߳�״̬ת��.c02_���02_RUNNABLE_two_WAITING;
/*
��� 2 RUNNABLE <--> WAITING
	t �߳��� synchronized(obj) ��ȡ�˶�������
		���� obj.wait() ����ʱ��t �̴߳� RUNNABLE --> WAITING
		���� obj.notify() �� obj.notifyAll() �� t.interrupt() ʱ
			�������ɹ���t �̴߳� WAITING --> RUNNABLE
			������ʧ�ܣ�t �̴߳� WAITING --> BLOCKED



*/