/**
 * 
 */
/**
 * @author 15753
 *
 */
package ��04��_����ģ��֮�ܳ�.s08_wait_notify����ȷ����.p01_step1;
/*

static final Object room = new Object();
static boolean hasCigarette = false;
static boolean hasTakeout = false;



*/
/*
 * ���ã�ԭ�����£�
	1.�����ɻ���̣߳���Ҫһֱ������Ч��̫��
	2.С���̱߳���˯�� 2s �������������������ǰ�͵���Ҳ�޷���������
	3.���� synchronized (room) �󣬾ͺñ�С�������淴������˯����
	     �̸���û���ͽ��ţ�main û��synchronized �ͺ��� main �߳��Ƿ�����������
	5.���������ʹ�� wait - notify ����
	
	---------------------------------
	��ʼ֮ǰ�ȿ�����
sleep(long n) �� wait(long n) ������
	1)sleep �� Thread �������� wait �� Object �ķ���
	2)sleep ����Ҫǿ�ƺ� synchronized ���ʹ�ã� �� wait ��Ҫ�� synchronized һ���� 
    3)sleep ��˯�ߵ�ͬʱ�������ͷŶ������ģ��� wait �ڵȴ���ʱ����ͷŶ����� 
    4)����״̬ TIMED_WAITING
 */