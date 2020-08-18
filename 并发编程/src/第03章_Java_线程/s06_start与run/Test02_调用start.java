package 第03章_Java_线程.s06_start与run;
//程序在 t1 线程运行， FileReader.read() 方法调用是异步的
import utils.Utils;

public class Test02_调用start {

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
