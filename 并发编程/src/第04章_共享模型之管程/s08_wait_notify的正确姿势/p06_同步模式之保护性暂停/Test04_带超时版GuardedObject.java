package 第04章_共享模型之管程.s08_wait_notify的正确姿势.p06_同步模式之保护性暂停;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import utils.Utils;

//如果要控制超时时间呢

class GuardedObjectV2 {
	private Object response;
	private final Object lock = new Object();

	public Object get(long millis) {
		synchronized (lock) {
			// 1) 记录最初时间
			long begin = System.currentTimeMillis();
			// 2) 已经经历的时间
			long timePassed = 0;
			while (response == null) {
				// 4) 假设 millis 是 1000，结果在 400 时唤醒了，那么还有 600 要等
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
				// 3) 如果提前被唤醒，这时已经经历的时间假设为 400
				timePassed = System.currentTimeMillis() - begin;
				Utils.log("timePassed:" + timePassed + ", "
						+ "object is null " + (response == null));
			}
			return response;
		}
	}

	public void complete(Object response) {
		synchronized (lock) {
			// 条件满足，通知等待线程
			this.response = response;
			Utils.log("notify...");
			lock.notifyAll();
		}
	}
}

public class Test04_带超时版GuardedObject {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Thread.currentThread().setName("get");
		// 测试，没有超时
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
//		测试，没有超时
		Object response = v2.get(2500);
		// 等待时间不足
//		List<String> lines = v2.get(1500);
		if (response != null) {
			Utils.log("get response: [" + ((List<String>) response).size() + "] lines");
		} else {
			Utils.log("can't get response");
		}
	}
}
