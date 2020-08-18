package p03_同步模式之顺序控制.s2_交替输出.s2_Lock条件变量版;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

import utils.Utils;

public class CrossOutput extends ReentrantLock{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void print(String str, Condition current, Condition next) {
		for (int i = 0; i < str.length(); i++) {
			this.lock();
			try {
				current.await(100, TimeUnit.MILLISECONDS);
//				Utils.log(str.charAt(i) + "");
				System.out.print(str.charAt(i));
				next.signal();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				this.unlock();
			}
		}
	}
	public void start(Condition first) {
		this.lock();
		try {
			Utils.log("start");
			first.signal();
		} finally {
			this.unlock();
		}
	}
	
	public static void main(String[] args) {
		String str1 = "123456789", str2 = "ABCDE";
		CrossOutput co = new CrossOutput();
		Condition str1WaitSet = co.newCondition();
		Condition str2WaitSet = co.newCondition();
		new Thread(() -> co.print(str1, str1WaitSet, str2WaitSet)).start();
		new Thread(() -> co.print(str2, str2WaitSet, str1WaitSet)).start();
		co.start(str1WaitSet);
	}

}
