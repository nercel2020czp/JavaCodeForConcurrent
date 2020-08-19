package 第06章_共享模型之无锁.s06_字段更新器;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

public class Test5 {
	//利用字段更新器，可以针对对象的某个域（Field）进行原子操作，只能配合 volatile 修饰的字段使用，否则会出现异常
	//Exception in thread "main" java.lang.IllegalArgumentException: Must be volatile type
	private /*volatile*/ int field;

	public static void main(String[] args) {
		AtomicIntegerFieldUpdater<Test5> fieldUpdater = AtomicIntegerFieldUpdater.newUpdater(Test5.class, "field");
		Test5 test5 = new Test5();
		fieldUpdater.compareAndSet(test5, 0, 10);
		// 修改成功 field = 10
		System.out.println(test5.field);
		// 修改成功 field = 20
		fieldUpdater.compareAndSet(test5, 10, 20);
		System.out.println(test5.field);
		// 修改失败 field = 20
		fieldUpdater.compareAndSet(test5, 10, 30);
		System.out.println(test5.field);
	}
}
