package ��06��_����ģ��֮����.s04_ԭ������.c04_ABA���⼰���.c01_ABA����;

import java.util.concurrent.atomic.AtomicReference;

import utils.Utils;

public class Test01_ABA���� {
	static AtomicReference<String> ref = new AtomicReference<>("A");

	public static void main(String[] args) throws InterruptedException {
		Utils.log("main start...");
		// ��ȡֵ A
		// ���������������߳��޸Ĺ���
		String prev = ref.get();
		other();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// ���Ը�Ϊ C
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
