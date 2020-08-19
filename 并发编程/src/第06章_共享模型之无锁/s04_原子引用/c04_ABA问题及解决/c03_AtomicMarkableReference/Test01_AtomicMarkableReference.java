package 第06章_共享模型之无锁.s04_原子引用.c04_ABA问题及解决.c03_AtomicMarkableReference;

import java.util.concurrent.atomic.AtomicMarkableReference;

import utils.Utils;

class GarbageBag {
	String desc;

	public GarbageBag(String desc) {
		this.desc = desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	@Override
	public String toString() {
		return super.toString() + " " + desc;
	}
}

public class Test01_AtomicMarkableReference {
	public static void main(String[] args) throws InterruptedException {
		GarbageBag bag = new GarbageBag("装满了垃圾");
		// 参数2 mark 可以看作一个标记，表示垃圾袋满了
		AtomicMarkableReference<GarbageBag> ref = new AtomicMarkableReference<>(bag, true);
		Utils.log("主线程 start...");
		GarbageBag prev = ref.getReference();
		Utils.log(prev.toString());
//		new Thread(() -> {
//			Utils.log("打扫卫生的线程 start...");
//			bag.setDesc("空垃圾袋");
//			while (!ref.compareAndSet(bag, bag, true, false)) {
//			}
//			Utils.log(bag.toString());
//		}).start();
		Thread.sleep(1000);
		Utils.log("主线程想换一只新垃圾袋？");
		boolean success = ref.compareAndSet(prev, new GarbageBag("空垃圾袋"), true, false);
		Utils.log("换了么？" + success);
		Utils.log(ref.getReference().toString());
	}
}
