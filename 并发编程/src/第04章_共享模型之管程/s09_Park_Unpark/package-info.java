/**
 * 
 */
/**
 * @author 15753
 *
 */
package ��04��_����ģ��֮�ܳ�.s09_Park_Unpark;
/*
����ʹ��
	������ LockSupport ���еķ���
		// ��ͣ��ǰ�߳�
		LockSupport.park();
		// �ָ�ĳ���̵߳�����
		LockSupport.unpark(��ͣ�̶߳���)
		
�ص�
	1.�� Object �� wait & notify ���wait��notify �� notifyAll ������� Object Monitor һ��ʹ�ã��� park��unpark ����
	2.park & unpark �����߳�Ϊ��λ�����������͡����ѡ��̣߳��� notify ֻ���������һ���ȴ��̣߳�notifyAll�ǻ������еȴ��̣߳��Ͳ���ô����ȷ��
	3.park & unpark ������ unpark���� wait & notify ������ notify
		
		
		

*/