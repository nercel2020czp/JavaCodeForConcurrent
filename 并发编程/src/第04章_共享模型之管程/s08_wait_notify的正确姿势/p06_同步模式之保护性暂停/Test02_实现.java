package 第04章_共享模型之管程.s08_wait_notify的正确姿势.p06_同步模式之保护性暂停;

class GuardedObject {
	private Object response;
	private final Object lock = new Object();

	public Object get() {
		synchronized (lock) {
			// 条件不满足则等待
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
			// 条件满足，通知等待线程
			this.response = response;
			lock.notifyAll();
		}
	}
}

public class Test02_实现 {

}
