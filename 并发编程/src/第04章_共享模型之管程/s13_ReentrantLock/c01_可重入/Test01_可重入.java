package ��04��_����ģ��֮�ܳ�.s13_ReentrantLock.c01_������;
/*
1.��������ָͬһ���߳�����״λ�������������ô��Ϊ�����������ӵ���ߣ������Ȩ���ٴλ�ȡ�����
    ����ǲ�������������ô�ڶ��λ����ʱ���Լ�Ҳ�ᱻ����ס

2.���������������þ��Ǳ�������

3.ReentrantLock/synchronized����һ�����͵Ŀ�������
*/
import java.util.concurrent.locks.ReentrantLock;
import utils.Utils;

public class Test01_������ {
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
