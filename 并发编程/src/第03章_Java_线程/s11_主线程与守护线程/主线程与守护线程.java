package ��03��_Java_�߳�.s11_���߳����ػ��߳�;
/*

Ĭ������£�Java ������Ҫ�ȴ������̶߳����н������Ż��������һ��������߳̽����ػ��̣߳�
ֻҪ�������ػ��߳����н����ˣ���ʹ�ػ��̵߳Ĵ���û��ִ���꣬Ҳ��ǿ�ƽ�����

ע��:
	1.�����������߳̾���һ���ػ��߳�
	2.Tomcat �е� Acceptor �� Poller �̶߳����ػ��̣߳�
	     ���� Tomcat ���յ� shutdown ����󣬲���ȴ����Ǵ����굱ǰ����

*/
import java.util.concurrent.TimeUnit;

import utils.Utils;

public class ���߳����ػ��߳� {

	public static void main(String[] args) throws InterruptedException {

		Utils.log("��ʼ����...");
		Thread t1 = new Thread(() -> {
			Utils.log("��ʼ����...");
			try {
				TimeUnit.SECONDS.sleep(4);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Utils.log("���н���...");
		}, "daemon");
		// ���ø��߳�Ϊ�ػ��߳�
		t1.setDaemon(true);
		t1.start();
		TimeUnit.SECONDS.sleep(2);
		Utils.log("���н���...");
		
	}

}
