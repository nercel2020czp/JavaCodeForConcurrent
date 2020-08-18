package 第04章_共享模型之管程.s04_变量的线程安全分析;
/*
//方法访问修饰符带来的思考，如果把 method2 和 method3 的方法修改为 public 会不会代理线程安全问题？
	情况1：有其它线程调用 method2 和 method3
	情况2：在 情况1 的基础上，为 ThreadSafe 类添加子类，子类覆盖 method2 或 method3 方法，即

从这个例子可以看出 private 或 final 提供【安全】的意义所在，请体会开闭原则中的【闭】

 */

import java.util.ArrayList;

class ThreadSafe1 {
	public final void method1(int loopNumber) {
		ArrayList<String> list = new ArrayList<>();
		for (int i = 0; i < loopNumber; i++) {
			method2(list);
			method3(list);
		}
	}

	private void method2(ArrayList<String> list) {
		list.add("1");
	}

	private void method3(ArrayList<String> list) {
		list.remove(0);
	}
}

class ThreadSafeSubClass1 extends ThreadSafe1 {
	public void method3(ArrayList<String> list) {
		new Thread(() -> {
			list.remove(0);
		}).start();
	}
}


public class Test03_方法访问修饰符带来的思考 {

}
