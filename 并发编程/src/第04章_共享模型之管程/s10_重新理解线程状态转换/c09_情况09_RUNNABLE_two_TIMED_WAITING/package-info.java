/**
 * 
 */
/**
 * @author 15753
 *
 */
package ��04��_����ģ��֮�ܳ�.s10_��������߳�״̬ת��.c09_���09_RUNNABLE_two_TIMED_WAITING;
/*

��� 8 RUNNABLE <--> TIMED_WAITING
	��ǰ�̵߳��� LockSupport.parkNanos(long nanos) �� LockSupport.parkUntil(long millis) ʱ����ǰ��
	�̴� RUNNABLE --> TIMED_WAITING
	���� LockSupport.unpark(Ŀ���߳�) ��������߳� �� interrupt() �����ǵȴ���ʱ������Ŀ���̴߳�
	TIMED_WAITING--> RUNNABLE

https://www.cnblogs.com/gosaint/p/9111189.html
	
�������������Ƿֱ�����˲�ͬ���̵߳Ĳ�ͬ״̬�¶����ж�����ķ�Ӧ��
NEW��TERMINATED�����жϲ������������εģ�RUNNABLE��BLOCKED���ƣ�
�����жϲ���ֻ�������жϱ�־λ��û��ǿ����ֹ�̣߳������̵߳���ֹȨ����Ȼ�ڳ������С�
WAITING/TIMED_WAITING״̬�µ��̶߳����жϲ��������еģ����ǻ��׳��쳣������жϱ�־λ��
*/