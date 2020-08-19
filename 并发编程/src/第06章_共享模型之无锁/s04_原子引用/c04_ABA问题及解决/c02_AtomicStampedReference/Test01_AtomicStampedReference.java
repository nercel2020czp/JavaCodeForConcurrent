package ��06��_����ģ��֮����.s04_ԭ������.c04_ABA���⼰���.c02_AtomicStampedReference;

import java.util.concurrent.atomic.AtomicStampedReference;

import utils.Utils;

public class Test01_AtomicStampedReference {
	static AtomicStampedReference<String> ref = new AtomicStampedReference<>("A", 0);

	public static void main(String[] args) throws InterruptedException {
		Utils.log("main start...");
		// ��ȡֵ A
		String prev = ref.getReference();
		// ��ȡ�汾��
		int stamp = ref.getStamp();
		Utils.log("�汾 : " + stamp);
		// ����м��������̸߳��ţ������� ABA ����
		other();
		Thread.sleep(1000);
		// ���Ը�Ϊ C
		Utils.log("change A->C : " + ref.compareAndSet(prev, "C", stamp, stamp + 1));
	}

	private static void other() {
		new Thread(() -> {
			Utils.log("change A->B : " + ref.compareAndSet(ref.getReference(), "B", ref.getStamp(), ref.getStamp() + 1));
			Utils.log("���°汾Ϊ : " + ref.getStamp());
		}, "t1").start();
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		new Thread(() -> {
			Utils.log("change B->A : " + ref.compareAndSet(ref.getReference(), "A", ref.getStamp(), ref.getStamp() + 1));
			Utils.log("���°汾Ϊ : " + ref.getStamp());
		}, "t2").start();
	}
}
