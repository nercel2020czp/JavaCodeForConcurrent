package ��04��_����ģ��֮�ܳ�.s04_�������̰߳�ȫ����;
/*�ȿ�һ����Ա����������:
	����һ������ǣ�����߳�2 ��δ add���߳�1 remove �ͻᱨ��
	Exception in thread "Thread1" java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
	at java.util.ArrayList.rangeCheck(ArrayList.java:657)
	at java.util.ArrayList.remove(ArrayList.java:496)
	at cn.itcast.n6.ThreadUnsafe.method3(TestThreadSafe.java:35)
	at cn.itcast.n6.ThreadUnsafe.method1(TestThreadSafe.java:26)
	at cn.itcast.n6.TestThreadSafe.lambda$main$0(TestThreadSafe.java:14)
	at java.lang.Thread.run(Thread.java:748)
	
������	
	1.�����ĸ��߳��е� method2 ���õĶ���ͬһ�������е� list ��Ա����
	2.method3 �� method2 ������ͬ
*
*/
import java.util.ArrayList;

//�ȿ�һ����Ա����������
class ThreadUnsafe {
	ArrayList<String> list = new ArrayList<>();

	public void method1(int loopNumber) {
		for (int i = 0; i < loopNumber; i++) {
			// { �ٽ���, �������̬����
			method2();
			method3();
			// } �ٽ���
		}
	}

	private void method2() {
		list.add("1");
	}

	private void method3() {
		list.remove(0);
	}
}
public class Test01_�ֲ��������������в�ͬ {
	static final int THREAD_NUMBER = 2;
	static final int LOOP_NUMBER = 200;

	public static void main(String[] args) {
		ThreadUnsafe test = new ThreadUnsafe();
		for (int i = 0; i < THREAD_NUMBER; i++) {
			new Thread(() -> {
				test.method1(LOOP_NUMBER);
			}, "Thread" + i).start();
		}
	}
}
/*
Exception in thread "Thread1" java.lang.ArrayIndexOutOfBoundsException: -1
	at java.util.ArrayList.add(Unknown Source)
	at ��04��_����ģ��֮�ܳ�.s04_�������̰߳�ȫ����.ThreadUnsafe.method2(Test01_�ֲ��������������в�ͬ.java:33)
	at ��04��_����ģ��֮�ܳ�.s04_�������̰߳�ȫ����.ThreadUnsafe.method1(Test01_�ֲ��������������в�ͬ.java:26)
	at ��04��_����ģ��֮�ܳ�.s04_�������̰߳�ȫ����.Test01_�ֲ��������������в�ͬ.lambda$0(Test01_�ֲ��������������в�ͬ.java:48)
	at java.lang.Thread.run(Unknown Source)
Exception in thread "Thread0" java.lang.ArrayIndexOutOfBoundsException: -1
	at java.util.ArrayList.remove(Unknown Source)
	at ��04��_����ģ��֮�ܳ�.s04_�������̰߳�ȫ����.ThreadUnsafe.method3(Test01_�ֲ��������������в�ͬ.java:37)
	at ��04��_����ģ��֮�ܳ�.s04_�������̰߳�ȫ����.ThreadUnsafe.method1(Test01_�ֲ��������������в�ͬ.java:27)
	at ��04��_����ģ��֮�ܳ�.s04_�������̰߳�ȫ����.Test01_�ֲ��������������в�ͬ.lambda$0(Test01_�ֲ��������������в�ͬ.java:48)
	at java.lang.Thread.run(Unknown Source)
*/
