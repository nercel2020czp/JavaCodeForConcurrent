package ��03��_Java_�߳�.s06_start��run;
//������ t1 �߳����У� FileReader.read() �����������첽��
import utils.Utils;

public class Test02_����start {

	public static void main(String[] args) {

		Thread t1 = new Thread("t1") {
			@Override
			public void run() {
				Utils.log("FileReader.read(Constants.MP4_FULL_PATH)");
//				FileReader.read(Constants.MP4_FULL_PATH);
			}
		};
		t1.start();
		Utils.log("do other things ...");
	}

}
