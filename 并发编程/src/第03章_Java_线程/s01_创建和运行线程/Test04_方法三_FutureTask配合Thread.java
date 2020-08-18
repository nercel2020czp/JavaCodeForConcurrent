package ��03��_Java_�߳�.s01_�����������߳�;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

import utils.Utils;

//FutureTask �ܹ����� Callable ���͵Ĳ��������������з��ؽ�������
public class Test04_������_FutureTask���Thread {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// �����������
		FutureTask<Integer> task3 = new FutureTask<>(() -> {
			Utils.log("hello");
			return 100;
		});
		// ����1 ���������; ����2 ���߳����֣��Ƽ�
		new Thread(task3, "t3").start();
		// ���߳�������ͬ���ȴ� task ִ����ϵĽ��
		Integer result = task3.get();
		Utils.log("�����: " + result);
	}
}
