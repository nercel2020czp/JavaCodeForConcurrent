package ��04��_����ģ��֮�ܳ�.s08_wait_notify����ȷ����.p06_ͬ��ģʽ֮��������ͣ;

class GuardedObject {
	private Object response;
	private final Object lock = new Object();

	public Object get() {
		synchronized (lock) {
			// ������������ȴ�
			while (response == null) {
				try {
					lock.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			return response;
		}
	}

	public void complete(Object response) {
		synchronized (lock) {
			// �������㣬֪ͨ�ȴ��߳�
			this.response = response;
			lock.notifyAll();
		}
	}
}

public class Test02_ʵ�� {

}
