/**
 * 
 */
/**
 * @author 15753
 *
 */
package ��04��_����ģ��֮�ܳ�.s08_wait_notify����ȷ����.p04_step4_��ٻ��ѵĽ��;

/*

notify ֻ���������һ�� WaitSet �е��̣߳���ʱ����������߳�Ҳ�ڵȴ�����ô�Ϳ��ܻ��Ѳ�����ȷ����
�̣���֮Ϊ����ٻ��ѡ�
�����������Ϊ notifyAll

���:
	20:55:23.978 [С��] c.TestCorrectPosture - ����û��[false]
	20:55:23.982 [С��] c.TestCorrectPosture - û�̣���Ъ�ᣡ
	20:55:23.982 [СŮ] c.TestCorrectPosture - �����͵�û��[false]
	20:55:23.982 [СŮ] c.TestCorrectPosture - û��������Ъ�ᣡ
	20:55:24.979 [��������] c.TestCorrectPosture - ���������ޣ�
	20:55:24.979 [СŮ] c.TestCorrectPosture - �����͵�û��[true]
	20:55:24.980 [СŮ] c.TestCorrectPosture - ���Կ�ʼ�ɻ���
	20:55:24.980 [С��] c.TestCorrectPosture - ����û��[false]
	20:55:24.980 [С��] c.TestCorrectPosture - û�ɳɻ�...
	
�� notifyAll �����ĳ���̵߳Ļ������⣬��ʹ�� if + wait �жϽ���һ�λ��ᣬһ����������������û������
�жϵĻ�����
����������� while + wait�����������������ٴ� wait

*/