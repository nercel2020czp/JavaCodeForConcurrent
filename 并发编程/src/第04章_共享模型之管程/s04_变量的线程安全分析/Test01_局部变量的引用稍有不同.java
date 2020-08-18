package 第04章_共享模型之管程.s04_变量的线程安全分析;
/*先看一个成员变量的例子:
	其中一种情况是，如果线程2 还未 add，线程1 remove 就会报错：
	Exception in thread "Thread1" java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
	at java.util.ArrayList.rangeCheck(ArrayList.java:657)
	at java.util.ArrayList.remove(ArrayList.java:496)
	at cn.itcast.n6.ThreadUnsafe.method3(TestThreadSafe.java:35)
	at cn.itcast.n6.ThreadUnsafe.method1(TestThreadSafe.java:26)
	at cn.itcast.n6.TestThreadSafe.lambda$main$0(TestThreadSafe.java:14)
	at java.lang.Thread.run(Thread.java:748)
	
分析：	
	1.无论哪个线程中的 method2 引用的都是同一个对象中的 list 成员变量
	2.method3 与 method2 分析相同
*
*/
import java.util.ArrayList;

//先看一个成员变量的例子
class ThreadUnsafe {
	ArrayList<String> list = new ArrayList<>();

	public void method1(int loopNumber) {
		for (int i = 0; i < loopNumber; i++) {
			// { 临界区, 会产生竞态条件
			method2();
			method3();
			// } 临界区
		}
	}

	private void method2() {
		list.add("1");
	}

	private void method3() {
		list.remove(0);
	}
}
public class Test01_局部变量的引用稍有不同 {
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
	at 第04章_共享模型之管程.s04_变量的线程安全分析.ThreadUnsafe.method2(Test01_局部变量的引用稍有不同.java:33)
	at 第04章_共享模型之管程.s04_变量的线程安全分析.ThreadUnsafe.method1(Test01_局部变量的引用稍有不同.java:26)
	at 第04章_共享模型之管程.s04_变量的线程安全分析.Test01_局部变量的引用稍有不同.lambda$0(Test01_局部变量的引用稍有不同.java:48)
	at java.lang.Thread.run(Unknown Source)
Exception in thread "Thread0" java.lang.ArrayIndexOutOfBoundsException: -1
	at java.util.ArrayList.remove(Unknown Source)
	at 第04章_共享模型之管程.s04_变量的线程安全分析.ThreadUnsafe.method3(Test01_局部变量的引用稍有不同.java:37)
	at 第04章_共享模型之管程.s04_变量的线程安全分析.ThreadUnsafe.method1(Test01_局部变量的引用稍有不同.java:27)
	at 第04章_共享模型之管程.s04_变量的线程安全分析.Test01_局部变量的引用稍有不同.lambda$0(Test01_局部变量的引用稍有不同.java:48)
	at java.lang.Thread.run(Unknown Source)
*/
