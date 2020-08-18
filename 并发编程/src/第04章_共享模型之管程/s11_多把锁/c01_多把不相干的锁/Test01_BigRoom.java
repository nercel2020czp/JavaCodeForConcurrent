package 第04章_共享模型之管程.s11_多把锁.c01_多把不相干的锁;
//某次结果
//12:13:54.471 [小南] c.BigRoom - study 1 小时
//12:13:55.476 [小女] c.BigRoom - sleeping 2 小时
import utils.Utils;

public class Test01_BigRoom {
	public void sleep() {
		synchronized (this) {
			Utils.log("sleeping 2 小时");
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void study() {
		synchronized (this) {
			Utils.log("study 1 小时");
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		Test01_BigRoom bigRoom = new Test01_BigRoom();
		new Thread(() -> {
			bigRoom.study();
		}, "小南").start();
		new Thread(() -> {
			bigRoom.sleep();
		}, "小女").start();
	}
}
