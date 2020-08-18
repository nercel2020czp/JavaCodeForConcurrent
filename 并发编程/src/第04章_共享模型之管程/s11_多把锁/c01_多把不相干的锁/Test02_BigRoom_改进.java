package 第04章_共享模型之管程.s11_多把锁.c01_多把不相干的锁;
//某次执行结果
//12:15:35.069 [小南] c.BigRoom - study 1 小时
//12:15:35.069 [小女] c.BigRoom - sleeping 2 小时
import utils.Utils;

public class Test02_BigRoom_改进 {
	private final Object studyRoom = new Object();
	private final Object bedRoom = new Object();

	public void sleep() {

		synchronized (bedRoom) {
			Utils.log("sleeping 2 小时");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void study() {
		synchronized (studyRoom) {
			Utils.log("study 1 小时");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		Test02_BigRoom_改进 bigRoom = new Test02_BigRoom_改进();
		new Thread(() -> {
			bigRoom.study();
		}, "小南").start();
		new Thread(() -> {
			bigRoom.sleep();
		}, "小女").start();
	}
	

}
