/**
 * 
 */
/**
 * @author 15753
 *
 */
package ��04��_����ģ��֮�ܳ�.s10_��������߳�״̬ת��.c05_���05_RUNNABLE_two_TIMED_WAITING;
/*

��� 5 RUNNABLE <--> TIMED_WAITING

t �߳��� synchronized(obj) ��ȡ�˶�������
	���� obj.wait(long n) ����ʱ��t �̴߳� RUNNABLE --> TIMED_WAITING
	t �̵߳ȴ�ʱ�䳬���� n ���룬����� obj.notify() �� obj.notifyAll() �� t.interrupt() ʱ
		�������ɹ���t �̴߳� TIMED_WAITING --> RUNNABLE
		������ʧ�ܣ�t �̴߳� TIMED_WAITING --> BLOCKED

https://www.cnblogs.com/gosaint/p/9111189.html
	
�������������Ƿֱ�����˲�ͬ���̵߳Ĳ�ͬ״̬�¶����ж�����ķ�Ӧ��
NEW��TERMINATED�����жϲ������������εģ�RUNNABLE��BLOCKED���ƣ�
�����жϲ���ֻ�������жϱ�־λ��û��ǿ����ֹ�̣߳������̵߳���ֹȨ����Ȼ�ڳ������С�
WAITING/TIMED_WAITING״̬�µ��̶߳����жϲ��������еģ����ǻ��׳��쳣������жϱ�־λ��
*/