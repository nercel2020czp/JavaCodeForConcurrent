/**
 * 
 */
/**
 * @author 15753
 *
 */
package ��04��_����ģ��֮�ܳ�.s10_��������߳�״̬ת��.c06_���06_RUNNABLE_two_TIMED_WAITING;
/*

��� 6 RUNNABLE <--> TIMED_WAITING
	��ǰ�̵߳��� t.join(long n) ����ʱ����ǰ�̴߳� RUNNABLE --> TIMED_WAITING
		ע���ǵ�ǰ�߳���t �̶߳���ļ������ϵȴ�
	��ǰ�̵߳ȴ�ʱ�䳬���� n ���룬��t �߳����н�����������˵�ǰ�̵߳� interrupt() ʱ����ǰ�̴߳�
		TIMED_WAITING --> RUNNABLE

https://www.cnblogs.com/gosaint/p/9111189.html
	
�������������Ƿֱ�����˲�ͬ���̵߳Ĳ�ͬ״̬�¶����ж�����ķ�Ӧ��
NEW��TERMINATED�����жϲ������������εģ�RUNNABLE��BLOCKED���ƣ�
�����жϲ���ֻ�������жϱ�־λ��û��ǿ����ֹ�̣߳������̵߳���ֹȨ����Ȼ�ڳ������С�
WAITING/TIMED_WAITING״̬�µ��̶߳����жϲ��������еģ����ǻ��׳��쳣������жϱ�־λ��
*/