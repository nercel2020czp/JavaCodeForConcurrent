package ��04��_����ģ��֮�ܳ�.s04_�������̰߳�ȫ����;
/*
//�����������η�������˼��������� method2 �� method3 �ķ����޸�Ϊ public �᲻������̰߳�ȫ���⣿
	���1���������̵߳��� method2 �� method3
	���2���� ���1 �Ļ����ϣ�Ϊ ThreadSafe ��������࣬���า�� method2 �� method3 ��������

��������ӿ��Կ��� private �� final �ṩ����ȫ�����������ڣ�����Ὺ��ԭ���еġ��ա�

 */

import java.util.ArrayList;

class ThreadSafe1 {
	public final void method1(int loopNumber) {
		ArrayList<String> list = new ArrayList<>();
		for (int i = 0; i < loopNumber; i++) {
			method2(list);
			method3(list);
		}
	}

	private void method2(ArrayList<String> list) {
		list.add("1");
	}

	private void method3(ArrayList<String> list) {
		list.remove(0);
	}
}

class ThreadSafeSubClass1 extends ThreadSafe1 {
	public void method3(ArrayList<String> list) {
		new Thread(() -> {
			list.remove(0);
		}).start();
	}
}


public class Test03_�����������η�������˼�� {

}
