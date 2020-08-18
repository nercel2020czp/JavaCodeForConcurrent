package 第04章_共享模型之管程.s13_ReentrantLock.c01_可重入;
/*
1.可重入是指同一个线程如果首次获得了这把锁，那么因为它是这把锁的拥有者，因此有权利再次获取这把锁
    如果是不可重入锁，那么第二次获得锁时，自己也会被锁挡住

2.可重入锁最大的作用就是避免死锁

3.ReentrantLock/synchronized就是一个典型的可重入锁
*/
import java.util.concurrent.locks.ReentrantLock;
import utils.Utils;

public class Test01_可重入 {
	static ReentrantLock lock = new ReentrantLock();

	public static void main(String[] args) {
		method1();
	}

	public static void method1() {
		lock.lock();
		try {
			Utils.log("execute method1");
			method2();
		} finally {
			lock.unlock();
		}
	}

	public static void method2() {
		lock.lock();
		try {
			Utils.log("execute method2");
			method3();
		} finally {
			lock.unlock();
		}
	}

	public static void method3() {
		lock.lock();
		try {
			Utils.log("execute method3");
		} finally {
			lock.unlock();
		}
	}
}
