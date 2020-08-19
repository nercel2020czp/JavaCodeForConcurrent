package ��06��_����ģ��֮����.s07_ԭ���ۼ���.c01_�ۼ������ܱȽ�_AtomicLong_LongAdder;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class Test01_AtomicLong_LongAdder {
	private static <T> void demo(Supplier<T> adderSupplier, Consumer<T> action) {
		T adder = adderSupplier.get();
		long start = System.nanoTime();
		List<Thread> ts = new ArrayList<>();
		// 4 ���̣߳�ÿ���ۼ� 50 ��
		for (int i = 0; i < 40; i++) {
			ts.add(new Thread(() -> {
				for (int j = 0; j < 500000; j++) {
					action.accept(adder);
				}
			}));
		}
		ts.forEach(t -> t.start());
		ts.forEach(t -> {
			try {
				t.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		long end = System.nanoTime();
		System.out.println(adder + " cost:" + (end - start) / 1000_000);
	}

	public static void main(String[] args) {
		for (int i = 0; i < 5; i++) {
			demo(() -> new LongAdder(), adder -> adder.increment());
		}
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		for (int i = 0; i < 5; i++) {
			demo(() -> new AtomicLong(), adder -> adder.getAndIncrement());
		}
	}
}
