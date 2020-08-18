package ��04��_����ģ��֮�ܳ�.s13_ReentrantLock;
/*
tryLock    public boolean tryLock()

���ڵ���ʱ��δ����һ���̱߳��ֵ�����£��Ż�ȡ������ 
 
1���������û�б���һ���̱߳��֣������������� true ֵ�������ı��ּ�������Ϊ 1��
��ʹ�ѽ���������Ϊʹ�ù�ƽ������ԣ����ǵ��� tryLock() �Խ� ������ȡ��������п��õģ���
�����������̵߳�ǰ�Ƿ����ڵȴ���������ĳЩ����£��ˡ����롱��Ϊ���ܺ����ã���ʹ������ƹ�
ƽ��Ҳ��ˡ����ϣ�����ش����Ĺ�ƽ���ã���ʹ�� tryLock(0, TimeUnit.SECONDS) 
���������ǵ�Ч�ģ�Ҳ����жϣ��� 
 
2�������ǰ�߳��Ѿ����ִ������򽫱��ּ����� 1���÷��������� true�� 
 
3�����������һ���̱߳��֣���˷������������� false ֵ�� 
 
ָ���ߣ�
   �ӿ� Lock �е�  tryLock
���أ� 
   ����������ɵĲ��ұ���ǰ�̻߳�ȡ�����ߵ�ǰ�߳��Ѿ����ָ������򷵻� true�����򷵻� 
false
*/
import java.util.concurrent.locks.ReentrantLock;

import utils.Utils;

public class Test04_����ʱ_tryLock {
	public static void main(String[] args) throws InterruptedException {
		ReentrantLock lock = new ReentrantLock();
		Thread t1 = new Thread(() -> {
			Utils.log("����...");
			if (!lock.tryLock()) {
				Utils.log("��ȡ����ʧ�ܣ�����");
				return;
			}
			try {
				Utils.log("�������");
			} finally {
				lock.unlock();
				Utils.log("�ͷ�����");
			}
		}, "t1");
		lock.lock();
		Utils.log("�������");
		t1.start();
		try {
			Thread.sleep(3000);
		} finally {
			lock.unlock();
			Utils.log("�ͷ�����");
		}
	}
}
