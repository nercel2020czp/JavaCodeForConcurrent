/**
 * 
 */
/**
 * @author 15753
 *
 */
package ��04��_����ģ��֮�ܳ�.s08_wait_notify����ȷ����.p05_step5_��ٻ��ѵĽ��2;

/*

�� notifyAll �����ĳ���̵߳Ļ������⣬��ʹ�� if + wait �жϽ���һ�λ��ᣬһ����������������û������
�жϵĻ�����
����������� while + wait�����������������ٴ� wait

���
20:58:34.322 [С��] c.TestCorrectPosture - ����û��[false]
20:58:34.326 [С��] c.TestCorrectPosture - û�̣���Ъ�ᣡ
20:58:34.326 [СŮ] c.TestCorrectPosture - �����͵�û��[false]
20:58:34.326 [СŮ] c.TestCorrectPosture - û��������Ъ�ᣡ
20:58:35.323 [��������] c.TestCorrectPosture - ���������ޣ�
20:58:35.324 [СŮ] c.TestCorrectPosture - �����͵�û��[true]
20:58:35.324 [СŮ] c.TestCorrectPosture - ���Կ�ʼ�ɻ���
20:58:35.324 [С��] c.TestCorrectPosture - û�̣���Ъ�ᣡ

synchronized(lock) {
	while(����������) {
		lock.wait();
	}
	// �ɻ�
}
//��һ���߳�
synchronized(lock) {
	lock.notifyAll();
}

*/