package ��03��_Java_�߳�.s06_start��run;
//�������� main �߳����У� FileReader.read() �������û���ͬ����
import utils.Utils;

public class Test01_����run {

	public static void main(String[] args) {

		Thread t1 = new Thread("t1") {
			@Override
			public void run() {
				Utils.log("");
//				FileReader.read(Constants.MP4_FULL_PATH);
				//FileReader.read() �������û���ͬ����
			}
		};
		t1.run();
		Utils.log("do other things ...");
	}

}
