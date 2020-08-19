package ��06��_����ģ��֮����.s06_�ֶθ�����;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

public class Test5 {
	//�����ֶθ�������������Զ����ĳ����Field������ԭ�Ӳ�����ֻ����� volatile ���ε��ֶ�ʹ�ã����������쳣
	//Exception in thread "main" java.lang.IllegalArgumentException: Must be volatile type
	private /*volatile*/ int field;

	public static void main(String[] args) {
		AtomicIntegerFieldUpdater<Test5> fieldUpdater = AtomicIntegerFieldUpdater.newUpdater(Test5.class, "field");
		Test5 test5 = new Test5();
		fieldUpdater.compareAndSet(test5, 0, 10);
		// �޸ĳɹ� field = 10
		System.out.println(test5.field);
		// �޸ĳɹ� field = 20
		fieldUpdater.compareAndSet(test5, 10, 20);
		System.out.println(test5.field);
		// �޸�ʧ�� field = 20
		fieldUpdater.compareAndSet(test5, 10, 30);
		System.out.println(test5.field);
	}
}
