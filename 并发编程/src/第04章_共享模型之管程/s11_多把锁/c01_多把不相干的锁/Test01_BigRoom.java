package ��04��_����ģ��֮�ܳ�.s11_�����.c01_��Ѳ���ɵ���;
//ĳ�ν��
//12:13:54.471 [С��] c.BigRoom - study 1 Сʱ
//12:13:55.476 [СŮ] c.BigRoom - sleeping 2 Сʱ
import utils.Utils;

public class Test01_BigRoom {
	public void sleep() {
		synchronized (this) {
			Utils.log("sleeping 2 Сʱ");
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
			Utils.log("study 1 Сʱ");
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
		}, "С��").start();
		new Thread(() -> {
			bigRoom.sleep();
		}, "СŮ").start();
	}
}
