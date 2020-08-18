package ��04��_����ģ��֮�ܳ�.s13_ReentrantLock.c04_��ƽ��;
/*ǿ�в��룬�л������м����
ע�⣺��ʵ�鲻һ�����ܸ���
��ƽ��һ��û�б�Ҫ���ή�Ͳ����ȣ��������ԭ��ʱ�ὲ��
-------------------------------------------------------
��ƽ��
    ��ָ����̰߳�����������˳������ȡ�������ŶӴ� ������
�ǹ�ƽ��
    ��ָ�ڶ��̻߳�ȡ����˳�򲢲��ǰ�����������˳��,�п��ܺ�������̱߳���
    ������߳����Ȼ�ȡ����,�ڸ߲����������,�п���������ȼ���ת���߼�������
-------------------------------------------------------
��ƽ��/�ǹ�ƽ��
  ������ReentrantLock�Ĵ�������ָ�����캯����boolean�������õ���ƽ�����߷ǹ�ƽ�� Ĭ���Ƿǹ�ƽ��
����ͼ  ��ƽ���ͷǹ�ƽ��.png��
-------------------------------------------------------
Java ReentrantLock����,
	ͨ���������ָ�������Ƿ��ǹ�ƽ�� Ĭ���Ƿǹ�ƽ�� �ǹ�ƽ�����ŵ������������ع�ƽ����.
 
 
����synchronized���� Ҳ��һ�ַǹ�ƽ��.


*/
import java.util.concurrent.locks.ReentrantLock;

import utils.Utils;

//ReentrantLock Ĭ���ǲ���ƽ��
public class Test01_��ƽ�� {
	public static void main(String[] args) throws InterruptedException {
		//falseĬ���Ƿǹ�ƽ��
//		ReentrantLock lock = new ReentrantLock(false);
		//��Ϊ��ƽ����
		ReentrantLock lock = new ReentrantLock(true);
		lock.lock();
		for (int i = 0; i < 10; i++) {
			new Thread(() -> {
				lock.lock();
				try {
					Utils.log("running...");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} finally {
					lock.unlock();
				}
			}, "t" + i).start();
		}
		
		// 1s ֮��ȥ������
		Thread.sleep(1000);
		
		new Thread(() -> {
			Utils.log("start...");
			lock.lock();
			try {
				Utils.log("running...");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} finally {
				lock.unlock();
			}
		}, "ǿ�в���").start();
		lock.unlock();
	}
}
