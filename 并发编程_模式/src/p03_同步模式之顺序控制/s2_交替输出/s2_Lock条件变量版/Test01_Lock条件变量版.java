package p03_同步模式之顺序控制.s2_交替输出.s2_Lock条件变量版;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

import utils.Utils;

class AwaitSignal extends ReentrantLock {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void start(Condition first) {
		this.lock();
		try {
			Utils.log("start");
			first.signal();
		} finally {
			this.unlock();
		}
	}

	public void print(String str, Condition current, Condition next) {
		for (int i = 0; i < loopNumber; i++) {
			this.lock();
			try {
				current.await();
				Utils.log(str);
				next.signal();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				this.unlock();
			}
		}
	}

	// 循环次数
	private int loopNumber;

	public AwaitSignal(int loopNumber) {
		this.loopNumber = loopNumber;
	}
}

public class Test01_Lock条件变量版 {
	public static void main(String[] args) {
		AwaitSignal as = new AwaitSignal(5);
		Condition aWaitSet = as.newCondition();
		Condition bWaitSet = as.newCondition();
		Condition cWaitSet = as.newCondition();
		new Thread(() -> {
			as.print("a", aWaitSet, bWaitSet);
		}).start();
		new Thread(() -> {
			as.print("b", bWaitSet, cWaitSet);
		}).start();
		new Thread(() -> {
			as.print("c", cWaitSet, aWaitSet);
		}).start();
		as.start(aWaitSet);
	}
}
