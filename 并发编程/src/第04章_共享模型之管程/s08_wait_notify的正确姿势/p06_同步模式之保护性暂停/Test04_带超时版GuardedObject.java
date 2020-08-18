package ��04��_����ģ��֮�ܳ�.s08_wait_notify����ȷ����.p06_ͬ��ģʽ֮��������ͣ;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import utils.Utils;

//���Ҫ���Ƴ�ʱʱ����

class GuardedObjectV2 {
	private Object response;
	private final Object lock = new Object();

	public Object get(long millis) {
		synchronized (lock) {
			// 1) ��¼���ʱ��
			long begin = System.currentTimeMillis();
			// 2) �Ѿ�������ʱ��
			long timePassed = 0;
			while (response == null) {
				// 4) ���� millis �� 1000������� 400 ʱ�����ˣ���ô���� 600 Ҫ��
				long waitTime = millis - timePassed;
				Utils.log("waitTime: " + waitTime);
				if (waitTime <= 0) {
					Utils.log("break...");
					break;
				}
				try {
					lock.wait(waitTime);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				// 3) �����ǰ�����ѣ���ʱ�Ѿ�������ʱ�����Ϊ 400
				timePassed = System.currentTimeMillis() - begin;
				Utils.log("timePassed:" + timePassed + ", "
						+ "object is null " + (response == null));
			}
			return response;
		}
	}

	public void complete(Object response) {
		synchronized (lock) {
			// �������㣬֪ͨ�ȴ��߳�
			this.response = response;
			Utils.log("notify...");
			lock.notifyAll();
		}
	}
}

public class Test04_����ʱ��GuardedObject {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Thread.currentThread().setName("get");
		// ���ԣ�û�г�ʱ
		GuardedObjectV2 v2 = new GuardedObjectV2();
		new Thread(() -> {
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
//			v2.complete(null);
//			try {
//				TimeUnit.SECONDS.sleep(2);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			v2.complete(Arrays.asList("a", "b", "c"));
		}, "complete").start();
//		Utils.log("getting...");
//		���ԣ�û�г�ʱ
		Object response = v2.get(2500);
		// �ȴ�ʱ�䲻��
//		List<String> lines = v2.get(1500);
		if (response != null) {
			Utils.log("get response: [" + ((List<String>) response).size() + "] lines");
		} else {
			Utils.log("can't get response");
		}
	}
}
