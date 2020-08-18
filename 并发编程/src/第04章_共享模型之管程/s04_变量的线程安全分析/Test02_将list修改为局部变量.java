package 第04章_共享模型之管程.s04_变量的线程安全分析;
/*
分析：

	1.list 是局部变量，每个线程调用时会创建其不同实例，没有共享
	2.而 method2 的参数是从 method1 中传递过来的，与 method1 中引用同一个对象
	3.method3 的参数分析与 method2 相同

【见图2.png】


*/
import java.util.ArrayList;

class ThreadSafe {
	public final void method1(int loopNumber) {
		//Test02_将list修改为局部变量
		//那么就不会有上述问题了
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

public class Test02_将list修改为局部变量 {

}
