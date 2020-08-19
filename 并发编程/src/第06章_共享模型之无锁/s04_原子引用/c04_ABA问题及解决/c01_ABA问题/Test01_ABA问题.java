package 第06章_共享模型之无锁.s04_原子引用.c04_ABA问题及解决.c01_ABA问题;

import java.util.concurrent.atomic.AtomicReference;

import utils.Utils;

public class Test01_ABA问题 {
	static AtomicReference<String> ref = new AtomicReference<>("A");

	public static void main(String[] args) throws InterruptedException {
		Utils.log("main start...");
		// 获取值 A
		// 这个共享变量被它线程修改过？
		String prev = ref.get();
		other();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 尝试改为 C
		Utils.log("change A->C : " + ref.compareAndSet(prev, "C"));
	}

	private static void other() {
		new Thread(() -> {
			Utils.log("change A->B : " + ref.compareAndSet(ref.get(), "B"));
		}, "t1").start();
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		new Thread(() -> {
			Utils.log("change B->A : " + ref.compareAndSet(ref.get(), "A"));
		}, "t2").start();
	}
}
