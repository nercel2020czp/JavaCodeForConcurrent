package ��04��_����ģ��֮�ܳ�.s11_�����.c01_��Ѳ���ɵ���;
//ĳ��ִ�н��
//12:15:35.069 [С��] c.BigRoom - study 1 Сʱ
//12:15:35.069 [СŮ] c.BigRoom - sleeping 2 Сʱ
import utils.Utils;

public class Test02_BigRoom_�Ľ� {
	private final Object studyRoom = new Object();
	private final Object bedRoom = new Object();

	public void sleep() {

		synchronized (bedRoom) {
			Utils.log("sleeping 2 Сʱ");
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
			Utils.log("study 1 Сʱ");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		Test02_BigRoom_�Ľ� bigRoom = new Test02_BigRoom_�Ľ�();
		new Thread(() -> {
			bigRoom.study();
		}, "С��").start();
		new Thread(() -> {
			bigRoom.sleep();
		}, "СŮ").start();
	}
	

}
