package ��04��_����ģ��֮�ܳ�.s04_�������̰߳�ȫ����;
/*
������

	1.list �Ǿֲ�������ÿ���̵߳���ʱ�ᴴ���䲻ͬʵ����û�й���
	2.�� method2 �Ĳ����Ǵ� method1 �д��ݹ����ģ��� method1 ������ͬһ������
	3.method3 �Ĳ��������� method2 ��ͬ

����ͼ2.png��


*/
import java.util.ArrayList;

class ThreadSafe {
	public final void method1(int loopNumber) {
		//Test02_��list�޸�Ϊ�ֲ�����
		//��ô�Ͳ���������������
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

public class Test02_��list�޸�Ϊ�ֲ����� {

}
