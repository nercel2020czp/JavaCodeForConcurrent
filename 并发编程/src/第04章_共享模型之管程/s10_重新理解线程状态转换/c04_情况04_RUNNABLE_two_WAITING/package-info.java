/**
 * 
 */
/**
 * @author 15753
 *
 */
package ��04��_����ģ��֮�ܳ�.s10_��������߳�״̬ת��.c04_���04_RUNNABLE_two_WAITING;
/*

��� 4 RUNNABLE <--> WAITING
	��ǰ�̵߳��� LockSupport.park() �������õ�ǰ�̴߳� RUNNABLE --> WAITING
	���� LockSupport.unpark(Ŀ���߳�) ��������߳� �� interrupt() ������Ŀ���̴߳� WAITING -->
	RUNNABLE

https://www.cnblogs.com/gosaint/p/9111189.html
	
�������������Ƿֱ�����˲�ͬ���̵߳Ĳ�ͬ״̬�¶����ж�����ķ�Ӧ��
NEW��TERMINATED�����жϲ������������εģ�RUNNABLE��BLOCKED���ƣ�
�����жϲ���ֻ�������жϱ�־λ��û��ǿ����ֹ�̣߳������̵߳���ֹȨ����Ȼ�ڳ������С�
WAITING/TIMED_WAITING״̬�µ��̶߳����жϲ��������еģ����ǻ��׳��쳣������жϱ�־λ��
*/