package ��03��_Java_�߳�.s01_�����������߳�;
/*// �����̶߳���
Thread t = new Thread() {
	public void run() {
		// Ҫִ�е�����
	}
};
// �����߳�
t.start();*/
import utils.Utils;

public class Test01_����һ_ֱ��ʹ��Thread {
	public static void main(String[] args) {
		// ���췽���Ĳ����Ǹ��߳�ָ�����֣��Ƽ�
		Thread t1 = new Thread("t1") {
			@Override
			// run ������ʵ����Ҫִ�е�����
			public void run() {
				Utils.log("hello");
			}
		};
		t1.start();
	}
}
