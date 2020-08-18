package ��04��_����ģ��֮�ܳ�.s08_wait_notify����ȷ����.p06_ͬ��ģʽ֮��������ͣ;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import utils.Utils;

/*
һ���̵߳ȴ���һ���̵߳�ִ�н��
*/
public class Test03_Ӧ�� {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		Thread.currentThread().setName("get");
		GuardedObject guardedObject = new GuardedObject();
		new Thread(() -> {
			// ���߳�ִ������
			try {
				Utils.log("downloading...");
				TimeUnit.SECONDS.sleep(4);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			List<String> response = new LinkedList<>();
			response.add("��ɭ��");
			response.add("�ȴ�");
			response.add("����");
			response.add("������");
			Utils.log("download complete...");
			guardedObject.complete(response);
		}, "complete").start();
		Utils.log("waiting...");
		// ���߳������ȴ�
//		Thread.currentThread().setName("get");
		Object response = guardedObject.get();
		Utils.log("get response:  " + ((List<String>) response).size() + " lines");
	}
}
