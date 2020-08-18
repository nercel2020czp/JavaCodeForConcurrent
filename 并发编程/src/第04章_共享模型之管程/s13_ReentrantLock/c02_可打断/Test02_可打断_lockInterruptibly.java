package ��04��_����ģ��֮�ܳ�.s13_ReentrantLock.c02_�ɴ��;
/*
lockInterruptibly
public void lockInterruptibly() throws InterruptedException
1�������ǰ�߳�δ���жϣ����ȡ���� 
2���������û�б���һ���̱߳��֣����ȡ�������������أ������ı��ּ�������Ϊ 1�� 
3�������ǰ�߳��Ѿ����ִ������򽫱��ּ����� 1�����Ҹ÷����������ء� 
4�����������һ���̱߳��֣�������̵߳���Ŀ�ģ����õ�ǰ�̣߳������ڷ��������������֮һ��
ǰ�����߳̽�һֱ��������״̬�� 
     1�����ɵ�ǰ�̻߳�ã����� 
     2������ĳ���߳��жϵ�ǰ�̡߳� 
5�������ǰ�̻߳�ø������������ּ�������Ϊ 1�� �����ǰ�̣߳� 
	 1���ڽ���˷���ʱ�Ѿ������˸��̵߳��ж�״̬������ 
	 2���ڵȴ���ȡ����ͬʱ���жϡ� 
   ���׳� InterruptedException�����������ǰ�̵߳����ж�״̬�� 
 
6���ڴ�ʵ���У���Ϊ�˷�����һ����ʽ�жϵ㣬����Ҫ���ȿ�����Ӧ�жϣ���������Ӧ������ͨ��ȡ��
�����ȡ�� 
	ָ���ߣ� �ӿ� Lock �е� lockInterruptibly
	�׳���   InterruptedException   �����ǰ�߳����жϡ�

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

public class Test02_�ɴ��_lockInterruptibly {
	public static void main(String[] args) throws InterruptedException {
		ReentrantLock lock = new ReentrantLock();
		Thread t1 = new Thread(() -> {
			Utils.log("����...");
			try {
				//lockInterruptibly ���ȿ�����Ӧ�жϣ���������Ӧ������ͨ��ȡ�������ȡ��
/*				4�����������һ���̡߳�main�����֣�������̵߳���Ŀ�ģ����õ�ǰ�̣߳������ڷ��������������֮һ��
				ǰ�����߳̽�һֱ��������״̬�� 
				     1�����ɵ�ǰ�̻߳�ã����� 
				     2������ĳ���߳��жϵ�ǰ�̡߳� */
				lock.lockInterruptibly();
			} catch (InterruptedException e) {
				e.printStackTrace();
				Utils.log("�����Ĺ����б����");
				return;
			}
			try {
				Utils.log("�������");
			} finally {
//				lock.unlock();
				Utils.log("�ͷ�����");
			}
			Utils.log("�ͷ�����...");
		}, "t1");
		lock.lock();
		Utils.log("�������");
		t1.start();
		try {
/*			1.ReentrantLock.lockInterruptibly�����ڵȴ�ʱ�������̵߳���
		     �ȴ��̵߳�Thread.interrupt�������жϵȴ��̵߳ĵȴ���ֱ�ӷ��أ�
		     ��ʱ���û�ȡ���������׳�һ��InterruptedException��*/
			Thread.sleep(3000);
			Utils.log("ִ�д��...");
			t1.interrupt();//1) �����ǰ�߳�δ���жϣ����ȡ���� 
			Utils.log("��ϳɹ�...");
		} finally {
			Utils.log("�ͷ���...");
			lock.unlock();
		}
	}
}
