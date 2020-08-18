package ��04��_����ģ��֮�ܳ�.s02_synchronized�������;

import utils.Utils;

/*
//�﷨
	synchronized(����) // �߳�1�� �߳�2(blocked)
	{
		�ٽ���
	}

���:�����´���


���������������ȣ�
	1.synchronized(����) �еĶ��󣬿�������Ϊһ�����䣨room������Ψһ��ڣ��ţ�
	    ����ֻ��һ�ν���һ�˽��м��㣬�߳� t1��t2 �����������
    2.���߳� t1 ִ�е� synchronized(room) ʱ�ͺñ� t1 ������������䣬����ס������
             ����Կ�ף�������ִ��count++ ����
    3.��ʱ����� t2 Ҳ���е��� synchronized(room) ʱ���������ű���ס�ˣ�ֻ����
             ����ȴ����������������л�������ס��
    4.���м伴ʹ t1 �� cpu ʱ��Ƭ�������꣬���߳������⣨��Ҫ�������Ϊ��ס�˶������һֱִ����ȥŶ����
	    ��ʱ�Ż�����ס�ģ�t1 ������Կ�ף�t2 �̻߳�������״̬��������ֻ���´��ֵ� t1 �Լ��ٴλ��ʱ��Ƭʱ��
             �ܿ��Ž���
    5.�� t1 ִ���� synchronized{} ���ڵĴ��룬��ʱ��Ż�� obj ����������⿪���ϵ�����
             ���� t2 �̰߳�Կ�׸�����t2 �߳���ʱ�ſ��Խ��� obj ���䣬��ס��������Կ�ף�ִ������
      count-- ����

��ͼ����ʾ��
	����ͼ1.png��

*/
public class Test02_synchronized {

	static int counter = 0;
	static final Object room = new Object();

	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(() -> {
			for (int i = 0; i < 5000; i++) {
				synchronized (room) {
					counter++;
				}
			}
		}, "t1");
		Thread t2 = new Thread(() -> {
			for (int i = 0; i < 5000; i++) {
				synchronized (room) {
					counter--;
				}
			}
		}, "t2");
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		Utils.log("" + counter);
	}

}
