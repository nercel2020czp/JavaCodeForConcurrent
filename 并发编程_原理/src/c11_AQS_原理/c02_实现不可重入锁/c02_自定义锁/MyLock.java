package c11_AQS_ԭ��.c02_ʵ�ֲ���������.c02_�Զ�����;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

import utils.Utils;

public class MyLock implements Lock {

	final class MySync extends AbstractQueuedSynchronizer {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		@Override
		protected boolean tryAcquire(int acquires) {
			if (acquires == 1) {
				if (compareAndSetState(0, 1)) {
					setExclusiveOwnerThread(Thread.currentThread());
					return true;
				}
			}
			return false;
		}

		@Override
		protected boolean tryRelease(int acquires) {
			if (acquires == 1) {
				if (getState() == 0) {
					throw new IllegalMonitorStateException();
				}
				setExclusiveOwnerThread(null);
				setState(0);
				return true;
			}
			return false;
		}

		protected Condition newCondition() {
			return new ConditionObject();
		}

		@Override
		protected boolean isHeldExclusively() {
			return getState() == 1;
		}
	}

	MySync sync = new MySync();

	// ���ԣ����ɹ�������ȴ�����
	@Override
	public void lock() {
		sync.acquire(1);
	}

	@Override
	// ���ԣ����ɹ�������ȴ����У��ɴ��
	public void lockInterruptibly() throws InterruptedException {
		sync.acquireInterruptibly(1);
	}

	@Override
	// ����һ�Σ����ɹ����أ����������
	public boolean tryLock() {
		return sync.tryAcquire(1);
	}

	@Override
	// ���ԣ����ɹ�������ȴ����У���ʱ��
	public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
		return sync.tryAcquireNanos(1, unit.toNanos(time));
	}

	@Override
	// �ͷ���
	public void unlock() {
		sync.release(1);
	}

	@Override
	// ������������
	public Condition newCondition() {
		return sync.newCondition();
	}

	/////////////// �� main �� /////////////////
	public static void main(String[] args) {
		MyLock lock = new MyLock();
		
		�����������(lock);
//		myLockTest(lock);
	}
	
	static void myLockTest(MyLock lock) {
		new Thread(() -> {
			lock.lock();
			try {
				Utils.log("locking...");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} finally {
				Utils.log("unlocking...");
				lock.unlock();
			}
		}, "t1").start();
		
		new Thread(() -> {
			lock.lock();
			try {
				Utils.log("locking...");
			} finally {
				Utils.log("unlocking...");
				lock.unlock();
			}
		}, "t2").start();
		
	}
	
	static void �����������(MyLock lock) {
		lock.lock();
		Utils.log("locking...");
		lock.lock();
		Utils.log("locking...");
	}

}
