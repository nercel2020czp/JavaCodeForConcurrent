/**
 * 
 */
/**
 * @author 15753
 *
 */
package c11_AQS_ԭ��.c01_����;

/*

1. ����
	ȫ���� AbstractQueuedSynchronizer��������ʽ������ص�ͬ�������ߵĿ��
	
�ص㣺
	1. �� state ��������ʾ��Դ��״̬���ֶ�ռģʽ�͹���ģʽ����������Ҫ�������ά�����״̬��������λ�ȡ�����ͷ���
		getState - ��ȡ state ״̬
		setState - ���� state ״̬
		compareAndSetState - cas �������� state ״̬
		��ռģʽ��ֻ��һ���߳��ܹ�������Դ��������ģʽ�����������̷߳�����Դ

	2. �ṩ�˻��� FIFO �ĵȴ����У������� Monitor �� EntryList
	
	3. ����������ʵ�ֵȴ������ѻ��ƣ�֧�ֶ������������������ Monitor �� WaitSet
	
������Ҫʵ������һЩ������Ĭ���׳� UnsupportedOperationException��
	tryAcquire
	tryRelease
	tryAcquireShared
	tryReleaseShared
	isHeldExclusively
	
��ȡ��������:
	// �����ȡ��ʧ��
	if (!tryAcquire(arg)) {
		// ���, ����ѡ��������ǰ�߳� park unpark
	}

�ͷ���������:
	// ����ͷ����ɹ�
	if (tryRelease(arg)) {
		// �������ָ̻߳�����
	}


*/