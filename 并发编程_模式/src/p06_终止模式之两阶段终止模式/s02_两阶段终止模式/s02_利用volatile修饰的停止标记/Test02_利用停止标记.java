package p06_终止模式之两阶段终止模式.s02_两阶段终止模式.s02_利用volatile修饰的停止标记;

import utils.Utils;

//停止标记用 volatile 是为了保证该变量在多个线程之间的可见性
//我们的例子中，即主线程把它修改为 true 对 t1 线程可见
class TPTVolatile {
	private Thread thread;
	private volatile boolean stop = false;

	public void start() {
		thread = new Thread(() -> {
//			Thread current = Thread.currentThread();
			while (true) {
				if (stop) {
					Utils.log("料理后事");
					break;
				}
				try {
					Thread.sleep(1000);
					Utils.log("将结果保存");
				} catch (InterruptedException e) {
				}
				// 执行监控操作
			}
		}, "监控线程");
		thread.start();
	}
	public void stop() {
		stop = true;
		thread.interrupt();
	}
}


public class Test02_利用停止标记 {
	public static void main(String[] args) throws InterruptedException {
		TPTVolatile t = new TPTVolatile();
		t.start();
		Thread.sleep(3500);
		Utils.log("stop");
		t.stop();
	}
}
