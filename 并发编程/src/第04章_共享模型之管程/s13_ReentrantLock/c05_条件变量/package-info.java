/**
 * 
 */
/**
 * @author 15753
 *
 */
package ��04��_����ģ��֮�ܳ�.s13_ReentrantLock.c05_��������;
/*��������
synchronized ��Ҳ�������������������ǽ�ԭ��ʱ�Ǹ� waitSet ��Ϣ�ң�
������������ʱ���� waitSet �ȴ�ReentrantLock ������������ synchronized ǿ��֮�����ڣ�
����֧�ֶ�����������ģ���ͺñ�synchronized ����Щ�������������̶߳���һ����Ϣ�ҵ���Ϣ
�� ReentrantLock ֧�ֶ����Ϣ�ң���ר�ŵ��̵���Ϣ�ҡ�ר�ŵ���͵���Ϣ�ҡ�����ʱҲ�ǰ���Ϣ��������

ʹ��Ҫ�㣺
	await ǰ��Ҫ�����
	await ִ�к󣬻��ͷ��������� conditionObject �ȴ�
	await ���̱߳����ѣ����ϡ���ʱ��ȡ���¾��� lock ��
	���� lock ���ɹ��󣬴� await �����ִ��

���
18:52:27.680 [main] c.TestCondition - ���������
18:52:27.682 [Thread-1] c.TestCondition - �ȵ����������
18:52:28.683 [main] c.TestCondition - ��������
18:52:28.683 [Thread-0] c.TestCondition - �ȵ���������
*/