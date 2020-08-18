package c11_AQS_ԭ��.c02_ʵ�ֲ���������.c01_�Զ���ͬ����;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;

final class MySync extends AbstractQueuedSynchronizer {
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
