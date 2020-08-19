package ��06��_����ģ��֮����.s04_ԭ������.c04_ABA���⼰���.c03_AtomicMarkableReference;

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
		GarbageBag bag = new GarbageBag("װ��������");
		// ����2 mark ���Կ���һ����ǣ���ʾ����������
		AtomicMarkableReference<GarbageBag> ref = new AtomicMarkableReference<>(bag, true);
		Utils.log("���߳� start...");
		GarbageBag prev = ref.getReference();
		Utils.log(prev.toString());
//		new Thread(() -> {
//			Utils.log("��ɨ�������߳� start...");
//			bag.setDesc("��������");
//			while (!ref.compareAndSet(bag, bag, true, false)) {
//			}
//			Utils.log(bag.toString());
//		}).start();
		Thread.sleep(1000);
		Utils.log("���߳��뻻һֻ����������");
		boolean success = ref.compareAndSet(prev, new GarbageBag("��������"), true, false);
		Utils.log("����ô��" + success);
		Utils.log(ref.getReference().toString());
	}
}
