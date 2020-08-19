package 第06章_共享模型之无锁.s04_原子引用.c04_ABA问题及解决.c02_AtomicStampedReference;

import java.util.concurrent.atomic.AtomicStampedReference;

import utils.Utils;

public class Test01_AtomicStampedReference {
	static AtomicStampedReference<String> ref = new AtomicStampedReference<>("A", 0);

	public static void main(String[] args) throws InterruptedException {
		Utils.log("main start...");
		// 获取值 A
		String prev = ref.getReference();
		// 获取版本号
		int stamp = ref.getStamp();
		Utils.log("版本 : " + stamp);
		// 如果中间有其它线程干扰，发生了 ABA 现象
		other();
		Thread.sleep(1000);
		// 尝试改为 C
		Utils.log("change A->C : " + ref.compareAndSet(prev, "C", stamp, stamp + 1));
	}

	private static void other() {
		new Thread(() -> {
			Utils.log("change A->B : " + ref.compareAndSet(ref.getReference(), "B", ref.getStamp(), ref.getStamp() + 1));
			Utils.log("更新版本为 : " + ref.getStamp());
		}, "t1").start();
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		new Thread(() -> {
			Utils.log("change B->A : " + ref.compareAndSet(ref.getReference(), "A", ref.getStamp(), ref.getStamp() + 1));
			Utils.log("更新版本为 : " + ref.getStamp());
		}, "t2").start();
	}
}
