package ��04��_����ģ��֮�ܳ�.s13_ReentrantLock;

/*lock
public void lock()
��ȡ����
�������û�б���һ���̱߳��֣����ȡ�������������أ������ı��ּ�������Ϊ 1��
�����ǰ�߳��Ѿ����ָ������򽫱��ּ����� 1�����Ҹ÷����������ء�
�����������һ���̱߳��֣�������̵߳��ȵ�Ŀ�ģ����õ�ǰ�̣߳������ڻ����֮ǰ�����߳̽�һ
ֱ��������״̬����ʱ�����ּ���������Ϊ 1��
 
ָ���ߣ�
�ӿ� Lock �е� lock
*/

/*lock()��lockInterruptibly()������
lock �� lockInterruptibly�Ƚ��������ڣ�
	1.lock ���ȿ��ǻ�ȡ��������ȡ���ɹ��󣬲���Ӧ�жϡ�
	2.lockInterruptibly ���ȿ�����Ӧ�жϣ���������Ӧ������ͨ��ȡ�������ȡ��
��ϸ����
	1.ReentrantLock.lockInterruptibly�����ڵȴ�ʱ�������̵߳���
	     �ȴ��̵߳�Thread.interrupt�������жϵȴ��̵߳ĵȴ���ֱ�ӷ��أ�
	     ��ʱ���û�ȡ���������׳�һ��InterruptedException��
    2.ReentrantLock.lock����������Thread.interrupt�ж�,��ʹ���
              ��Thread.isInterrupted,һ����������Ի�ȡ����ʧ����������ߡ�
              ֻ��������ȡ���ɹ����ٰѵ�ǰ�߳���Ϊinterrupted״̬,Ȼ�����ж��̡߳�
 */
import java.util.concurrent.locks.ReentrantLock;

import utils.Utils;

public class Test03_�ɴ��_lock {
	public static void main(String[] args) throws InterruptedException {
		ReentrantLock lock = new ReentrantLock();
		Thread t1 = new Thread(() -> {
			Utils.log("����...");
			//lock ���ȿ��ǻ�ȡ��������ȡ���ɹ��󣬲���Ӧ�жϡ�
			lock.lock();
			try {
				Utils.log("�������");
			} finally {
				Utils.log("�ͷ�����...");
				lock.unlock();
			}
			Utils.log("�ͷ�����...");
		}, "t1");
		lock.lock();
		Utils.log("�������");
		t1.start();
		try {
/*		    ReentrantLock.lock����������Thread.interrupt�ж�,��ʹ���
            ��Thread.isInterrupted,һ����������Ի�ȡ����ʧ����������ߡ�
            ֻ��������ȡ���ɹ����ٰѵ�ǰ�߳���Ϊinterrupted״̬,Ȼ�����ж��̡߳�*/
			Thread.sleep(3000);
			Utils.log("ִ�д��");
			t1.interrupt();//��ʱ t1 ��û�б��������, �����Լ����ȴ���
			Utils.log("��ϳɹ�");
			Thread.sleep(3000);
		} finally {
			Utils.log("�ͷ�����");
			lock.unlock();
		}
	}
}
